package com.example.data.datastores.remote.interfaces

import com.example.data.datastores.remote.entities.BeerContent
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET

interface BeerApiDef {
    @GET("beers")
    fun listBeers() : Flowable<List<BeerContent>>
}