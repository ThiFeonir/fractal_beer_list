package com.example.data.datastores.remote.mappers

import com.example.data.datastores.remote.entities.BeerContent
import com.example.domain.entities.Beer
import com.example.domain.mappers.Mapper

class BeerMapper : Mapper<BeerContent, Beer>() {
    override fun transform(value: BeerContent): Beer {
        return Beer(
                beerName = value.beerName,
                beerTagLine = value.tagLine,
                beerDescription = value.beerDescription,
                beerImg = value.beerImg
        )
    }

}