package com.example.dddkotlin.product.ports.rest

import com.example.dddkotlin.product.domain.EventBus
import com.example.dddkotlin.product.domain.product.ProductNumber
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Um controlador REST para simular os dois pontos de partida do aplicativo de demonstração:
 *
 * - O "MasterDataUpdateAvailableEvent" é gerado pelo "Master Data Service".
 * - O "MediaDataUpdateAvailableEvent" é gerado pelo "Media Data Service".
 *
 * Veja o "HELP.md" para uma visão geral do processo de negócios!
 */

@RestController
class DemoController(
    private val eventBus: EventBus
) {

    @PostMapping("/master_data_update")
    fun masterDataUpdate(): ResponseEntity<String> {
        // Simula um evento de entrada de outro sistema externo.
        // Em nosso exemplo, este evento seria lançado pelo externo
        // "Master Data Service".
       val result = eventBus.send(
            MasterDataUpdateAvailableEvent(
                productNumber = ProductNumber("P-000001"),
                name = "Coca-Cola",
                description = "A bottle of tasty Coca Cola"
            )
        )
        return ResponseEntity.ok(result)
    }

    @PostMapping("/media_data_update")
    fun mediaDataUpdate(@RequestBody imageUrl: String): ResponseEntity<String> {
        // Simula um evento de entrada de outro sistema externo.
        // Em nosso exemplo, este evento seria lançado pelo externo
        // "Media Data Service".
       val result = eventBus.send(
           //OUVIDO PELO LISTENER - MediaDataUpdateAvailableEventListener
            MediaDataUpdateAvailableEvent(
                productNumber = ProductNumber("P-000001"),
                imageUrl = imageUrl
            )
        )
        return ResponseEntity.ok(result)
    }

}