package com.example.demo.service

import com.example.demo.dto.Product
import java.math.BigDecimal

/*
Интерфейс (Interface) - используется для определения общих методов и свойств,
которые должны быть реализованы во всех классах, которые реализуют этот интерфейс.
В данном коде интерфейс ProductService определяет общие методы.
 */
interface ProductService {
    fun createProduct(name: String, price: BigDecimal): Product
    fun deleteProduct(id: Long)
}