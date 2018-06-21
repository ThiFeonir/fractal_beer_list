package com.example.data.datastores.extensions

import com.example.domain.entities.defaults.Packet
import io.reactivex.subjects.PublishSubject

fun <T> PublishSubject<Packet<T>>.success(data: T) =
        apply {
            loading(false)
            onNext(Packet.Sucess(data))
        }

fun <T> PublishSubject<Packet<T>>.failure(throwable: Throwable) =
        apply {
            loading(false)
            onNext(Packet.Failure(throwable))
        }

fun <T> PublishSubject<Packet<T>>.loading(isLoading: Boolean) =
        apply { onNext(Packet.Loading(isLoading)) }