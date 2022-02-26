package com.example.dddkotlin.product.domain

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@EventListener
@Async
annotation class CommandListener
