package com.example.kotlinrestdemo.interfaces

import com.example.kotlinrestdemo.models.Todo
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name="TodoClient", url="https://jsonplaceholder.typicode.com")
interface TodoClient {
    @GetMapping( "/todos")
    fun getTodos(): List<Todo>
}

@FeignClient(name="SwansonClient", url="https://ron-swanson-quotes.herokuapp.com/v2/quotes")
interface SwansonClient {
    @GetMapping( "/swanson")
    fun getQuote(): ResponseEntity<String>
}
