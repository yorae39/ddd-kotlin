package com.example.dddkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class DddKotlinApplication

fun main(args: Array<String>) {
    runApplication<DddKotlinApplication>(*args)
}
