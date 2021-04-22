package com.example.kotlinrestdemo.repositories

import com.example.kotlinrestdemo.models.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {
    fun findTodoById(id: Int): Todo?
}