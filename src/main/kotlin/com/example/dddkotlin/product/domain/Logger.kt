package com.example.dddkotlin.product.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.full.companionObject

private fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)

private fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}

fun <T : Any> T.logger(): Logger = getLogger(
    getClassForLogging(javaClass)
)