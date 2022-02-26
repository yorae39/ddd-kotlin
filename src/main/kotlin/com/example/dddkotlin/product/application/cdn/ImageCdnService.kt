package com.example.dddkotlin.product.application.cdn

import com.example.dddkotlin.product.domain.CommandListener
import com.example.dddkotlin.product.domain.logger
import org.springframework.stereotype.Service

@Service
class ImageCdnService() {

    @CommandListener
    fun handle(command: UpdateCdnCommand) {
        /* Aqui seria o lugar para alguma lógica de negócios
           interagindo com a imagem externa CDN.
         */
        logger().info("Image CDN has been updated. [productNumber={}]", command.productNumber)
    }
}