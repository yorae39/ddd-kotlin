package com.example.dddkotlin.product.domain

interface EventBus {
    fun send(event: Event)
    fun sendAll(events: List<Event>){
        events.forEach(this::send)
    }
}