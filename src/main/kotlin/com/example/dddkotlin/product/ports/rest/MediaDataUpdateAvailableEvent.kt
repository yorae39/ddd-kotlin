package com.example.dddkotlin.product.ports.rest

import com.example.dddkotlin.product.domain.Event
import com.example.dddkotlin.product.domain.product.ProductNumber

//OUVIDO PELO LISTENER - MediaDataUpdateAvailableEventListener
data class MediaDataUpdateAvailableEvent(
    val productNumber: ProductNumber,
    val imageUrl: String
): Event