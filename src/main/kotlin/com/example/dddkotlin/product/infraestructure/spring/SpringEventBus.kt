package com.example.dddkotlin.product.infraestructure.spring

import com.example.dddkotlin.product.domain.Event
import com.example.dddkotlin.product.domain.EventBus
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SpringEventBus(
    private val eventPublisher: ApplicationEventPublisher
): EventBus {

    override fun send(event: Event) {
        eventPublisher.publishEvent(event)
    }
}