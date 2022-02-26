package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.Event

//OUVIDO PELO LISTENER - MasterDataUpdatedEventListener
data class MasterDataUpdatedEvent(
    val productNumber: ProductNumber
): Event