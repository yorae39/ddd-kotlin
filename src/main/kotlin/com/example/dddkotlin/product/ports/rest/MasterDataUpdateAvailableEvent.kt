package com.example.dddkotlin.product.ports.rest

import com.example.dddkotlin.product.domain.Event
import com.example.dddkotlin.product.domain.product.ProductNumber

//OUVIDO PELO LISTENER - MasterDataUpdateAvailableEventListener
data class MasterDataUpdateAvailableEvent(
    val productNumber: ProductNumber,
    val name: String,
    val description: String
): Event