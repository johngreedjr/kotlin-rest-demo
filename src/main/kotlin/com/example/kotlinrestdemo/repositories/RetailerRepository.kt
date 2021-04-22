package com.example.kotlinrestdemo.repositories

import com.example.kotlinrestdemo.models.Retailer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RetailerRepository : JpaRepository<Retailer, Long> {

    fun findByRetailerName(name: String): Retailer?

    @Query(value = "SELECT * FROM RETAILERS ORDER BY retailer_stock DESC LIMIT 1", nativeQuery = true )
    fun findTopByOrderByRetailerStockDesc(): Retailer?

}