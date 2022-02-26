package com.example.dddkotlin.product.application.search

import com.example.dddkotlin.product.domain.Command
import com.example.dddkotlin.product.domain.product.ProductNumber

data class UpdateSearchIndexCommand(
    val productNumber: ProductNumber
): Command