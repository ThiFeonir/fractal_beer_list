package com.example.domain.repositories

import com.example.domain.entities.Beer
import com.example.domain.entities.defaults.Packet
import io.reactivex.subjects.PublishSubject

interface Repository {

    fun getListBeer(): PublishSubject<Packet<List<Beer>>>
}