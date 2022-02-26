package com.example.dddkotlin.product.application.mediadata

import com.example.dddkotlin.product.domain.Command
import com.example.dddkotlin.product.domain.product.ProductNumber

//PROVOCA StubbedMediaDataRegistry
data class RegisterForMediaDataUpdatesCommand(
    val productNumber: ProductNumber
): Command