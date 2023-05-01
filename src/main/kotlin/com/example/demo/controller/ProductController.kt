package com.example.demo.controller

import com.example.demo.dto.Product
import com.example.demo.service.ProductService
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal


/*
Принцип инверсии зависимостей (Dependency Inversion Principle) служит для создания слабосвязанных сущностей,
которые легко тестировать, модифицировать и обновлять.
В данном случае в классе ProductController указана зависимость от интерфейса ProductService.
Spring выполняет функцию DI и внедряет нужную реализацию интерфейса ProductService
 */
@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {
    @PostMapping
    fun createProduct(@RequestBody productRequest: ProductRequest): ProductResponse {
        val product = productService.createProduct(
            productRequest.name,
            productRequest.price,
        )
        return ProductResponse(product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productService.deleteProduct(id)
    }

    data class ProductRequest(val name: String, val price: BigDecimal)

    data class ProductResponse(val id: Long?, val name: String, val price: BigDecimal) {
        constructor(product: Product) : this(product.id, product.name, product.price)
    }
}
