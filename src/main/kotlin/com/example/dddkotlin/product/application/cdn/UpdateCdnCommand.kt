package com.example.dddkotlin.product.application.cdn

import com.example.dddkotlin.product.domain.Command
import com.example.dddkotlin.product.domain.product.ProductNumber
/*
    CDN (Content Delivery Network) é uma Rede de Distribuição de Conteúdo
*/
data class UpdateCdnCommand(
    val productNumber: ProductNumber
): Command