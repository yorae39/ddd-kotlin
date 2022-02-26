package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.Command

data class UpdateMediaDataCommand(
    val productNumber: ProductNumber,
    val imageUrl: String
): Command