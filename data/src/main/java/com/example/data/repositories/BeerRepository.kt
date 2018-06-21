package com.example.data.repositories

import com.example.data.RemoteDataProvider
import com.example.data.datastores.extensions.failure
import com.example.data.datastores.extensions.success
import com.example.data.datastores.remote.mappers.BeerMapper
import com.example.domain.entities.Beer
import com.example.domain.entities.defaults.Packet
import com.example.domain.repositories.Repository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class BeerRepository : Repository {

    private val remoteDataProvider = RemoteDataProvider()
    private val beerMapper = BeerMapper()
    private val compositeDisposable = CompositeDisposable()
    private val contentPublishSubject = PublishSubject.create<Packet<List<Beer>>>()

    override fun getListBeer(): PublishSubject<Packet<List<Beer>>> {
        remoteDataProvider
                .recentBeers()
                .map(beerMapper::transform)
                .subscribeOn(Schedulers.io())
                .subscribe({ contentPublishSubject.success(it) }, { contentPublishSubject.failure(it) })
                .let(compositeDisposable::add)

        return contentPublishSubject
    }

}