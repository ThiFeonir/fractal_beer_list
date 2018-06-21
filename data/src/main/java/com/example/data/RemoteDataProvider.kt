package com.example.data

import com.example.data.datastores.DataProvider
import com.example.data.datastores.remote.BeerApi
import com.example.data.datastores.remote.entities.BeerContent
import io.reactivex.Flowable

class RemoteDataProvider : DataProvider {
    override fun recentBeers(): Flowable<List<BeerContent>> =
            BeerApi
                .provideApiService()
                .listBeers()

}