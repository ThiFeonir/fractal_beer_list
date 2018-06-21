package com.example.teste.repositories

import io.reactivex.Observable

interface Repository {

    fun getListBeer(): Observable<List<Beer>>
}