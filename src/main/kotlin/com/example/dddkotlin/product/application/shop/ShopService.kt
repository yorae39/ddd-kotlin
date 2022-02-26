package com.example.dddkotlin.product.application.shop

import com.example.dddkotlin.product.domain.CommandListener
import com.example.dddkotlin.product.domain.logger
import org.springframework.stereotype.Service

@Service
class ShopService() {

    @CommandListener
    fun handle(command: UpdateShopCommand) {
        // Aqui seria o lugar para alguma lógica de negócios
        // interagindo com o sistema de loja externo.
        logger().info("Shop has been updated. [productNumber={}]", command.productNumber)
    }
}