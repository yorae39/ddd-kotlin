package com.example.dddkotlin.product.infraestructure.spring

import com.example.dddkotlin.product.domain.Command
import com.example.dddkotlin.product.domain.CommandBus
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SpringCommandBus(
    private val eventPublisher: ApplicationEventPublisher
): CommandBus {

    override fun send(command: Command): String {
       eventPublisher.publishEvent(command)
        return command.toString()
    }
}