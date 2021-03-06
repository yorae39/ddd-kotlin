package com.example.dddkotlin.product.domain

interface CommandBus {
    fun send(command: Command): String
    fun sendAll(commands: List<Command>){
       commands.forEach(this::send)
    }
}