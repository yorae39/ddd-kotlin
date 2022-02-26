package com.example.dddkotlin.product.domain

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * O esqueleto abstrato de uma entidade de domínio. Uma entidade de domínio é um objeto
 * do Domain Driven Design. Ele encapsula dados e comportamento. Este
 * significa que não apenas contém dados, mas também contém os métodos de negócios em
 * ordem para manipulá-lo. Após a manipulação dos dados, um evento de domínio
 * será criado. Outros contextos podem ouvir e reagir a este evento. Esta
 * classe abstrata fornece métodos convenientes para lidar com esses eventos.
 *
 * Cada entidade de domínio tem um ID exclusivo. Isso significa que a identidade de uma
 * entidade de domínio é baseada em seu ID e não nos dados atuais. Para
 * refletir esse conceito no código, sobrescrevemos equals() e hashCode().
 */
abstract class DomainEntity<T : Any>(val id: T) {

    //private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val occurredEvents: MutableList<Event> = mutableListOf()

    fun occurredEvents(): List<Event> {
        val events = this.occurredEvents.toMutableList()
        this.occurredEvents.clear()
        logger().trace("Return occurred domains events. [numberOfEvents=${events.size}]")
        return events
    }

    protected fun raise(event: Event) {
        occurredEvents.add(event)
        logger().debug("Raised new domain event. [type=${event::class.simpleName}")
    }

    override fun equals(other: Any?): Boolean {
        if(other!!.javaClass != javaClass){
            return false
        }
        return EqualsBuilder().append(this.id, (other as DomainEntity<*>).id) // Somente no ID!
            .isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder().append(id) // Somente no ID!
            .toHashCode()
    }
}