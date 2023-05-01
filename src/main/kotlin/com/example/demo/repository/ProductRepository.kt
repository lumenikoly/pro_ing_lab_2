package com.example.demo.repository

import com.example.demo.dto.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/*
Интерфейс (Interface) - используется для определения общих методов и свойств,
которые должны быть реализованы во всех классах, которые реализуют этот интерфейс.
В данном коде интерфейс ProductRepository определяет общие методы для работы с базой данных
и позволяет Spring сгенерировать нужные методы, унаследованные от CrudRepository.
 */
/*
Наследование является базовым принципом ООП и позволяет одному классу (наследнику)
унаследовать функционал другого класса (родительского).
Данный интерфейс унаследован от CrudRepository для реализации стандартных методов репозитория
 */
@Repository
interface ProductRepository : CrudRepository<Product, Long>