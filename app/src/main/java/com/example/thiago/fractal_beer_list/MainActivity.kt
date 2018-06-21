package com.example.thiago.fractal_beer_list

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thiago.fractal_beer_list.data.api.BeerApi
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BeerApi.provideApiService()
                .listBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    Log.d("beers", "List size: ${it.size}")
                            it.forEach {
                                Log.d("beers", "${it.beerName}\n${it.tagLine}\n${it.beerDescription}\n")
                            }
                },
                        {
                            Log.e("Error", it.message)
                        })
    }
}
