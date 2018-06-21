package com.example.domain.usecase.defaults

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

abstract class UseCase<PARAMS, RESULT>{

    abstract fun executeUseCase(params: PARAMS): PublishSubject<RESULT>

    fun getObservable(params: PARAMS): Observable<RESULT> =
            executeUseCase(params)
                    .subscribeOn(Schedulers.io())
}