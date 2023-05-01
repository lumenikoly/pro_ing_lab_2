package com.example.demo.service.impl

import com.example.demo.dto.Product
import com.example.demo.repository.ProductRepository
import com.example.demo.service.ProductService
import com.example.demo.util.ProductBuilder
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.math.BigDecimal

/*
Одиночка (Singleton, Синглтон) -
порождающий паттерн, который гарантирует,
что для определенного класса будет создан только один объект,
а также предоставит к этому объекту точку доступа.
В данном случае синглтоном является ProductServiceImpl для использования в многопоточных вызовах из REST контроллера.
 */
@Service
@RequiredArgsConstructor
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    /*
    Паттерн Заместитель (Proxy) предоставляет объект-заместитель, который управляет доступом к другому объекту.
    То есть создается объект-суррогат, который может выступать в роли другого объекта и замещать его
    @Transactional создаёт proxy-объект для реализации транзакционности в помеченный аннотацией методах
     */
    @Transactional
    override fun createProduct(name: String, price: BigDecimal): Product {
        val product = ProductBuilder()
            .setName(name)
            .setPrice(price)
            .build()
        return productRepository.save(product)
    }

    @Transactional
    override fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }
}