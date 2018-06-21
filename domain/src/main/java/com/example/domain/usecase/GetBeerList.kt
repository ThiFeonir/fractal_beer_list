package com.example.domain.usecase

import com.example.domain.entities.Beer
import com.example.domain.entities.defaults.Packet
import com.example.domain.repositories.Repository
import com.example.domain.usecase.defaults.UseCase

class GetBeerList(private val repository: Repository) : UseCase<Unit, Packet<List<Beer>>>(){

    override fun executeUseCase(params: Unit) = repository.getListBeer()

}