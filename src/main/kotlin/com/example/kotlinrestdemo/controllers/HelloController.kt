package com.example.kotlinrestdemo.controllers

import com.example.kotlinrestdemo.interfaces.SwansonClient
import com.example.kotlinrestdemo.interfaces.TodoClient
import com.example.kotlinrestdemo.services.RetailerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min


@RestController
@Validated
class HelloController(val service: RetailerService) {
    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = ("Hello, $name");

    @GetMapping("/getallretailers")
    fun getAllRetailers() = service.findRetailers()

    @PostMapping("/newretailer")
    fun newRetailer(@RequestParam(value = "retailerName", required = true) retailerName: String,
                    @RequestParam(value = "retailerStock", required = true)@Min(0) retailerStock: Int): String {
        return service.postRetailer(retailerName, retailerStock)
    }

    @DeleteMapping("/deleteretailer")
    fun deleteRetailer(@RequestParam(value = "retailerName", required = true) retailerName: String): String {
        return service.deleteRetailer(retailerName)
    }

    @PutMapping("/updateretailerstock")
    fun updateStock(@RequestParam(value = "retailerName", required = true) retailerName: String,
                    @RequestParam(value = "retailerStock", required = true) retailerStock: Int): String {
        return service.updateRetailer(retailerName, retailerStock)
    }

    @GetMapping("/gethigheststock")
    fun gethigheststock() = service.getHighestStock()


    @Autowired
    var todoClient: TodoClient? = null

    @GetMapping("/todos")
    fun getTodos() = todoClient?.getTodos()

    @Autowired
    var swansonClient: SwansonClient? = null

    @GetMapping("/swanson")
    fun getQuote() = swansonClient?.getQuote()

}