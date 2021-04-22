package com.example.kotlinrestdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class KotlinRestDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinRestDemoApplication>(*args)
}
