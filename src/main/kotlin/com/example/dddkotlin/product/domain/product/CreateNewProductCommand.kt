package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.Command

data class CreateNewProductCommand(
    val productNumber: ProductNumber,
    val name: String,
    val description: String
): Command