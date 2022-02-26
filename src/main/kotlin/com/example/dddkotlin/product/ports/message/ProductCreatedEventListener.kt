package com.example.dddkotlin.product.ports.message

import com.example.dddkotlin.product.application.mediadata.RegisterForMediaDataUpdatesCommand
import com.example.dddkotlin.product.application.search.UpdateSearchIndexCommand
import com.example.dddkotlin.product.application.shop.UpdateShopCommand
import com.example.dddkotlin.product.domain.CommandBus
import com.example.dddkotlin.product.domain.EventListener
import com.example.dddkotlin.product.domain.product.ProductCreatedEvent
import org.springframework.stereotype.Component

@Component
class ProductCreatedEventListener(
    private val commandBus: CommandBus
) {

    //OUVE O EVENTO - ProductCreatedEvent
    @EventListener
    fun handle(event: ProductCreatedEvent) {
        commandBus.send(
            RegisterForMediaDataUpdatesCommand(productNumber = event.productNumber)
        )

        commandBus.send(
            UpdateShopCommand(productNumber = event.productNumber)
        )

        commandBus.send(
            UpdateSearchIndexCommand(productNumber = event.productNumber)
        )
    }

}