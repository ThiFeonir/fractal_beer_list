package com.example.domain.entities.defaults

sealed class Packet<T> {

    data class Loading<T>(val isLoading: Boolean) : Packet<T>()
    data class Sucess<T>(val data: T) : Packet<T>()
    data class Failure<T>(val throwable: Throwable) : Packet<T>()

}