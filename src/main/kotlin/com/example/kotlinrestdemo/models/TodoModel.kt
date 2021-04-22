package com.example.kotlinrestdemo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: String? = null,
    var id: Int = 0,
    var title: String? = null,
    var isCompleted: Boolean = false
)