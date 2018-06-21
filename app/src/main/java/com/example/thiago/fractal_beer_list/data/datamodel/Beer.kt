package com.example.thiago.fractal_beer_list.data.datamodel

import com.squareup.moshi.Json


class Beer (@Json(name = "name") val beerName : String,
            @Json(name = "tagline") val tagLine : String,
            @Json(name = "image_url") val beerImg : String,
            @Json(name = "description") val beerDescription: String)
