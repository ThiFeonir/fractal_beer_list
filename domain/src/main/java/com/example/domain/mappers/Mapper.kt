package com.example.domain.mappers

abstract class Mapper<IN, OUT>{

    abstract fun transform(value: IN) : OUT

    fun transform(values: List<IN>) : List<OUT>{
        return values.map(this::transform)
    }
}