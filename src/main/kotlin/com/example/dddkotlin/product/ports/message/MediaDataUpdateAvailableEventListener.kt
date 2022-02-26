package com.example.dddkotlin.product.ports.message

import com.example.dddkotlin.product.domain.CommandBus
import com.example.dddkotlin.product.domain.EventListener
import com.example.dddkotlin.product.domain.product.UpdateMediaDataCommand
import com.example.dddkotlin.product.ports.rest.MediaDataUpdateAvailableEvent
import org.springframework.stereotype.Component

@Component
class MediaDataUpdateAvailableEventListener(
    private val commandBus: CommandBus
) {

    //OUVE O EVENTO - MediaDataUpdateAvailableEvent
    @EventListener
    fun handle(event: MediaDataUpdateAvailableEvent) {
        commandBus.send(
            UpdateMediaDataCommand(
                productNumber = event.productNumber,
                imageUrl = event.imageUrl
            )
        )
    }
}