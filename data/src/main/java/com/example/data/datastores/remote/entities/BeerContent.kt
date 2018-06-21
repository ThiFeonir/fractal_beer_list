package com.example.data.datastores.remote.entities

import com.squareup.moshi.Json


class BeerContent (@Json(name = "name") val beerName : String,
            @Json(name = "tagline") val tagLine : String,
            @Json(name = "image_url") val beerImg : String,
            @Json(name = "description") val beerDescription: String)
