package com.example.domain.entities

import java.io.Serializable

data class Beer (
        val beerName : String,
        val beerTagLine : String,
        val beerImg : String,
        val beerDescription : String
) : Serializable