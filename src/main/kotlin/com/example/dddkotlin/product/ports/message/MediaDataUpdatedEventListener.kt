package com.example.dddkotlin.product.ports.message

import com.example.dddkotlin.product.application.cdn.UpdateCdnCommand
import com.example.dddkotlin.product.domain.CommandBus
import com.example.dddkotlin.product.domain.EventListener
import com.example.dddkotlin.product.domain.product.MediaDataUpdatedEvent
import org.springframework.stereotype.Component

@Component
class MediaDataUpdatedEventListener(
    private val commandBus: CommandBus
) {

    //OUVE O EVENTO - MediaDataUpdatedEvent
    @EventListener
    fun handle(event: MediaDataUpdatedEvent) {
        val updateCdnCommand = UpdateCdnCommand(event.productNumber)
        commandBus.send(updateCdnCommand)
    }
}