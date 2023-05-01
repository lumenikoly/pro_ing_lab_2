package com.example.demo.util

import com.example.demo.dto.Product
import java.math.BigDecimal

/*
Строитель (Builder) - используется для создания объектов Product с большим количеством параметров.
Данный паттерн позволяет упростить инициализацию объектов, делая код более читаемым и поддерживаемым.
 */
class ProductBuilder {
    private var id: Long? = null
    private lateinit var name: String
    private var price: BigDecimal = BigDecimal.ZERO

    fun setId(id: Long?): ProductBuilder {
        this.id = id
        return this
    }

    fun setName(name: String): ProductBuilder {
        this.name = name
        return this
    }

    fun setPrice(price: BigDecimal): ProductBuilder {
        this.price = price
        return this
    }

    fun build(): Product {
        return Product(id, name, price)
    }
}
