package com.example.apresentation.ui.beers

import com.example.domain.entities.Beer

interface BeerRowView {

    fun setBeerName(beerName : String)

    fun setBeerTagLine(beerTagLine : String)

    fun setBeerImg(beerImage: String)

    fun setClickListener(beer: Beer)
}