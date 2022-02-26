package com.example.dddkotlin.product.domain.product

import org.springframework.util.Assert

data class ProductNumber(
    val productNumber: String
) {
    private val productNumberFormat = Regex("P-[0-9]{6}")

    init {

        Assert.state(
            productNumber.matches(productNumberFormat),
            "Product number has invalid format: $productNumber"
        )
    }

    fun stringValue(): String {
        return productNumber
    }

    override fun toString(): String {
        return productNumber
    }
}