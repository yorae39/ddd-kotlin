<u> DDD com Kotlin</u>
=====================

Projeto de exemplo do conceito DDD - Domain Driven Design com Kotlin

###

### Simule os eventos de entrada:

```
POST to http://localhost:8080/master_data_update
POST to http://localhost:8080/media_data_update
```

### Caso de uso de exemplo:

O assunto desta demonstração é o `Product Service`.
O `Product Service` está localizado entre cinco outros componentes.
O `Master Data Service` enviará novos produtos para o `Product Service`.
Este é o início do nosso processo de negócios.
O `Product Service` registrará cada novo produto no `Media Data Service`.
Após o registro de um produto, o `Product Service` receberá atualizações para este produto do `Media Data Service`.
Após o recebimento de uma atualização, o `Product Service`:
- Atualiza o `CDN` se os dados de mídia foram alterados
- Atualiza o `Shop` e o `search index` se os dados mestres foram alterados

```
+-------------+
| Master Data |
|   Service   |
+-------------+
   |                     << DEMO >>   
   +------------------► +---------+
    1: update product   | Product |
                        | Service |---------+---------+
               +------► +---------+         |         |
      3:       |             |      2:      |         |        5:
 push updates  |             | register new |         | update if master 
               |             |   product    |         | data has changed
   +------------+            |              |         |
   | Media Data | ◄----------+              |         +----------+
   |  Service   |                           |         |          |
   +------------+        4: update if media |         |          |
                          data has changed  |         |          |
                                            ▼         ▼          ▼
                                         +-----+  +------+  +--------+ 
                                         | CDN |  | Shop |  | Search |
                                         +-----+  +------+  +--------+
```

### O que ver:

- Uma entidade de domínio chamada `Product.kt` que encapsula a lógica de negócios e lança eventos de domínio.
- Um fluxo de processo com eventos ("algo aconteceu") e comandos ("agora faça algo").
- Objetos de valor como `ProductNumber.kt` ou `ProductInformation.kt`.
- Um layout de pacote de portas e adaptadores.
- Uma camada anticorrupção para eventos externos - eles serão transformados em comandos internos.


### Créditos ao projeto original: [ddd-with-kotlin](https://github.com/bringmeister/ddd-with-kotlin)
