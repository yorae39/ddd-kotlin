package com.example.dddkotlin.product.ports.message

import com.example.dddkotlin.product.application.cdn.UpdateCdnCommand
import com.example.dddkotlin.product.domain.CommandBus
import com.example.dddkotlin.product.domain.EventListener
import com.example.dddkotlin.product.domain.product.CreateNewProductCommand
import com.example.dddkotlin.product.domain.product.ProductRepository
import com.example.dddkotlin.product.domain.product.UpdateMasterDataCommand
import com.example.dddkotlin.product.ports.rest.MasterDataUpdateAvailableEvent
import org.springframework.stereotype.Component

@Component
class MasterDataUpdateAvailableEventListener(
    private val commandBus: CommandBus,
    private val productRepository: ProductRepository
) {

    //OUVE O EVENTO - MasterDataUpdateAvailableEvent
    @EventListener
    fun handle(event: MasterDataUpdateAvailableEvent): String {

        val productExists = productRepository.exists(event.productNumber)

        return if (productExists) {
            commandBus.send(
                UpdateMasterDataCommand(
                    productNumber = event.productNumber,
                    name = event.name,
                    description = event.description
                )
            )

        } else {
            commandBus.send(
                CreateNewProductCommand(
                    productNumber = event.productNumber,
                    name = event.name,
                    description = event.description
                )
            )
        }
    }
}