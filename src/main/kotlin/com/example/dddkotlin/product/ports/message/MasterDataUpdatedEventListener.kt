package com.example.dddkotlin.product.ports.message

import com.example.dddkotlin.product.application.search.UpdateSearchIndexCommand
import com.example.dddkotlin.product.application.shop.UpdateShopCommand
import com.example.dddkotlin.product.domain.CommandBus
import com.example.dddkotlin.product.domain.EventListener
import com.example.dddkotlin.product.domain.product.MasterDataUpdatedEvent
import org.springframework.stereotype.Component

@Component
class MasterDataUpdatedEventListener(
    private val commandBus: CommandBus
) {

    // OUVE O EVENTO - MasterDataUpdatedEvent
    @EventListener
    fun handle(event: MasterDataUpdatedEvent) {
        commandBus.send(
            UpdateShopCommand(
                productNumber = event.productNumber
            )
        )

        commandBus.send(
            UpdateSearchIndexCommand(
                productNumber = event.productNumber
            )
        )
    }
}