package com.example.data.datastores

import com.example.data.datastores.remote.entities.BeerContent
import io.reactivex.Flowable

interface DataProvider {

    fun recentBeers() : Flowable<List<BeerContent>>
}