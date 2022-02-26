package com.example.dddkotlin.product.application.shop

import com.example.dddkotlin.product.domain.Command
import com.example.dddkotlin.product.domain.product.ProductNumber

data class UpdateShopCommand(
    val productNumber: ProductNumber
): Command