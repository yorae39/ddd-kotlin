package com.example.dddkotlin.product.infraestructure.stubs

import com.example.dddkotlin.product.domain.product.Product
import com.example.dddkotlin.product.domain.product.ProductNumber
import com.example.dddkotlin.product.domain.product.ProductRepository
import org.springframework.stereotype.Component

@Component
class StubbedProductRepository : ProductRepository {

    private val products = mutableMapOf<String, Product>()

    override fun find(productNumber: ProductNumber): Product {
        return products[productNumber.productNumber] ?: throw RuntimeException("Product not found : ${productNumber.productNumber}")
    }

    override fun exists(productNumber: ProductNumber): Boolean {
        return products.containsKey(productNumber.productNumber)
    }

    override fun save(product: Product) {
        products[product.id.productNumber] = product
    }

    fun clear() {
        products.clear()
    }
}