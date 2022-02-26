package com.example.dddkotlin.product.domain.product

import com.example.dddkotlin.product.domain.DomainEntity
import com.example.dddkotlin.product.domain.logger
import org.springframework.util.Assert

/**
 * A entidade de domínio do produto.
 *
 * Esta entidade encapsula todas as informações que pertencem a um produto.
 * Também fornece métodos de negócios para trabalhar com essas informações. Dados
 * não pode ser alterado de fora - não há setters.
 *
 * Sempre que os dados forem alterados, um evento de domínio será lançado. Este evento
 * informa a qualquer ouvinte que algo mudou no contexto de um produto.
 * Em um exemplo da vida real, esses eventos seriam publicados sobre
 * um agente de mensagens como Kafka, ActiveMQ ou AWS Kinesis.
 */
class Product(
    command: CreateNewProductCommand
): DomainEntity<ProductNumber>(command.productNumber){

    var productInformation: ProductInformation
        private set

    var imageUrl: String? = null // não temos nenhuma até obtermos a primeira atualização de dados de mídia
        private set

    init {

        Assert.hasText(command.name, "Product name must not be empty!")
        Assert.hasText(command.description, "Product description must not be empty!")

        productInformation = ProductInformation(
            name = command.name,
            description = command.description
        )

        raise(ProductCreatedEvent(productNumber = id))
        logger().info("New product created. [productNumber={}]", id)
    }

    fun handle(command: UpdateMasterDataCommand) {

        Assert.hasText(command.name, "Product name must not be empty!")
        Assert.hasText(command.description, "Product description must not be empty!")

        this.productInformation = ProductInformation(
            name = command.name,
            description = command.description
        )

        raise(MasterDataUpdatedEvent(productNumber = id))
        logger().info("Product master data updated. [productNumber={}]", id)
    }

    fun handle(command: UpdateMediaDataCommand) {
        Assert.hasText(command.imageUrl, "Image url must not be empty!")
        this.imageUrl = command.imageUrl

        raise(MediaDataUpdatedEvent(productNumber = id))
        logger().info("Product media data updated. [productNumber={}]", id)
    }
}