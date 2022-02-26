package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.Event

//OUVIDO PELO LISTENER - MediaDataUpdatedEventListener
data class MediaDataUpdatedEvent(
    val productNumber: ProductNumber
): Event