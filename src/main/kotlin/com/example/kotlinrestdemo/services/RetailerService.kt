package com.example.kotlinrestdemo.services

import com.example.kotlinrestdemo.models.Retailer
import com.example.kotlinrestdemo.repositories.RetailerRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class RetailerService(val db: RetailerRepository) {
    fun findRetailers(): List<Retailer> = db.findAll()

    fun postRetailer(name: String, stock: Int): String{
        val retailer = Retailer()
        retailer.retailerName = name
        retailer.retailerStock = stock

        db.save(retailer)
        return "$name has been added with a stock of $stock."
    }

    fun deleteRetailer(name: String): String {
        val entityToDelete = db.findByRetailerName(name)

        if (entityToDelete != null) {
            db.delete(entityToDelete)
        }

        return "$name has been deleted."
    }

    fun updateRetailer(name: String, stock: Int): String {
        if (stock < 0) {
            return "A value of $stock is not allowed."
        }

        val entityToUpdate = db.findByRetailerName(name)

        if (entityToUpdate != null) {
            entityToUpdate.retailerStock = stock
            db.save(entityToUpdate)
            return "$name updated stock to $stock"
        }
        return "Name cannot be null"
    }

    fun getHighestStock() = db.findTopByOrderByRetailerStockDesc()
}