package com.example.dddkotlin.product.infraestructure.stubs

import com.example.dddkotlin.product.application.mediadata.MediaDataRegistry
import com.example.dddkotlin.product.application.mediadata.RegisterForMediaDataUpdatesCommand
import com.example.dddkotlin.product.domain.EventBus
import com.example.dddkotlin.product.domain.logger
import com.example.dddkotlin.product.ports.rest.MediaDataUpdateAvailableEvent
import org.springframework.stereotype.Component

/*
    Um stub ou method stub, em português esboço de método, em desenvolvimento de software,
    é um pedaço de código usado para substituir algumas outras funcionalidades de programação.
    Um stub pode simular o comportamento de um código existente (como um procedimento em uma máquina remota)
    ou ser um substituto temporário para o código ainda a ser desenvolvido. Eles são portanto mais úteis
    em portabilidade, computação distribuída bem como no desenvolvimento e teste de software em geral.

    São partes (fragmentos) de algoritmos que provêm a abstração de uma chamada (local) de procedimento (método)
    fazendo a ligação deste com o mecanismo de comunicação. Stubs são como um proxy para os objetos remotos,
    são partes do código que fazem a chamada remota, são utilizados no cliente e no servidor.
*/
@Component
class StubbedMediaDataRegistry(
    private val eventBus: EventBus
): MediaDataRegistry {

    override fun handle(command: RegisterForMediaDataUpdatesCommand) {
        logger().info("Registered for media data updates. [productNumber=${command.productNumber}]")
        // Este evento simula a resposta de outro sistema externo. Depois que
        // um produto foi registrado para atualizações no serviço de dados de mídia,
        // este serviço eventualmente nos enviará uma atualização.

        eventBus.send(
            MediaDataUpdateAvailableEvent(
                productNumber = command.productNumber,
                imageUrl = "www.my-domain.com/my-new-image.jpg"
            )
        )
    }

}