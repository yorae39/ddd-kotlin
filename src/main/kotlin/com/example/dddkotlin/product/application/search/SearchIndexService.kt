package com.example.dddkotlin.product.application.search

import com.example.dddkotlin.product.domain.CommandListener
import com.example.dddkotlin.product.domain.logger
import org.springframework.stereotype.Service

@Service
class SearchIndexService() {

    @CommandListener
    fun handle(command: UpdateSearchIndexCommand) {
        /*
            Aqui seria o lugar para alguma lógica de negócios
            interagindo com o índice de pesquisa externo.
         */
        logger().info("Search index has been updated. [productNumber={}]", command.productNumber)
    }
}