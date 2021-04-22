package com.example.kotlinrestdemo.services

import com.example.kotlinrestdemo.models.Retailer
import com.example.kotlinrestdemo.repositories.RetailerRepository
import org.springframework.stereotype.Service

@Service
class RetailerService(val retailerRepository: RetailerRepository) {
    fun findRetailers(): List<Retailer> = retailerRepository.findAll()

    fun postRetailer(name: String, stock: Int): String{
        val retailer = Retailer()
        retailer.retailerName = name
        retailer.retailerStock = stock

        retailerRepository.save(retailer)
        return "$name has been added with a stock of $stock."
    }

    fun deleteRetailer(name: String): String {
        val entityToDelete = retailerRepository.findByRetailerName(name)

        if (entityToDelete != null) {
            retailerRepository.delete(entityToDelete)
        }

        return "$name has been deleted."
    }

    fun updateRetailer(name: String, stock: Int): String {
        if (stock < 0) {
            return "A value of $stock is not allowed."
        }

        val entityToUpdate = retailerRepository.findByRetailerName(name)

        if (entityToUpdate != null) {
            entityToUpdate.retailerStock = stock
            retailerRepository.save(entityToUpdate)
            return "$name updated stock to $stock"
        }
        return "Name cannot be null"
    }

    fun getHighestStock() = retailerRepository.findTopByOrderByRetailerStockDesc()
}