package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.Event

//OUVIDO PELO LISTENER - ProductCreatedEventListener
data class ProductCreatedEvent(
    val productNumber: ProductNumber
): Event