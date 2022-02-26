package com.example.dddkotlin.product.application.product

import com.example.dddkotlin.product.domain.CommandListener
import com.example.dddkotlin.product.domain.EventBus
import com.example.dddkotlin.product.domain.logger
import com.example.dddkotlin.product.domain.product.CreateNewProductCommand
import com.example.dddkotlin.product.domain.product.Product
import com.example.dddkotlin.product.domain.product.ProductRepository
import com.example.dddkotlin.product.domain.product.UpdateMasterDataCommand
import com.example.dddkotlin.product.domain.product.UpdateMediaDataCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService() {

    @Autowired
    private lateinit var productRepository: ProductRepository
    @Autowired
    private lateinit var eventBus: EventBus

    @CommandListener
    fun handle(command: CreateNewProductCommand) {
        val product = Product(command)
        productRepository.save(product)
        eventBus.sendAll(product.occurredEvents())
    }

    @CommandListener
    fun handle(command: UpdateMasterDataCommand) {
        val product = productRepository.find(command.productNumber)
        product.handle(command)
        productRepository.save(product)
        eventBus.sendAll(product.occurredEvents())
    }

    @CommandListener
    fun handle(command: UpdateMediaDataCommand) {
        if(productRepository.exists(command.productNumber)){
            val product = productRepository.find(command.productNumber)
            logger().trace("Image of product before actualization : ${product.imageUrl}")
            product.handle(command)
            logger().trace("Image of product after actualization : ${product.imageUrl}")
            productRepository.save(product)
            val events = product.occurredEvents()
            eventBus.sendAll(events)
        } else {
            logger().info("Media data ignored as product doesn't exist. [productNumber=$command.productNumber]")
        }
    }
}