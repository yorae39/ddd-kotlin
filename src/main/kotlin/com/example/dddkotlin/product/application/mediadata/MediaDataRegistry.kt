package com.example.dddkotlin.product.application.mediadata

interface MediaDataRegistry {
    fun handle(command: RegisterForMediaDataUpdatesCommand)
}