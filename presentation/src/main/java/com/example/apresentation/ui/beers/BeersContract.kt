package com.example.apresentation.ui.beers

import com.example.domain.entities.Beer
import com.example.domain.entities.defaults.Packet


interface BeersContract {

    interface View {
        fun showBeers()

        fun showBeerDetail(beerId : String)

        fun showEmptyList()

        fun onDataChanged()

        fun isLoadingData(loading: Boolean)

        fun showErrorResponse(throwable: Throwable)
    }

    interface Presenter{

        fun attachView(view : View)

        fun loadBeers()

        fun onBindBeerRowViewAtPosition(position : Int, view : BeerRowView)

        fun getBeerRowCount() : Int

        fun notifyDataChanged()
    }
}