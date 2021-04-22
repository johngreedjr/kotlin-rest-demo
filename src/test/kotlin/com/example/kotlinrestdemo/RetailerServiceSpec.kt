package com.example.kotlinrestdemo

import com.example.kotlinrestdemo.models.Retailer
import com.example.kotlinrestdemo.repositories.RetailerRepository
import com.example.kotlinrestdemo.services.RetailerService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RetailerServiceSpec {
    @Mock
    lateinit var retailerRepository: RetailerRepository
    @InjectMocks
    lateinit var retailerService: RetailerService

    @Test
    fun testFindAllService() {
        Mockito.`when`(retailerRepository.findAll()).thenReturn(listOf(Retailer(), Retailer()))
        val result = retailerService.findRetailers();
        assert(result.size == 2) { "Expected 2 but found ${result.size}" }
    }

    @Test
    fun testPostService() {
        val result = retailerService.postRetailer("foo", 3)

        Mockito.`when`(retailerRepository.save(any())).thenReturn(Retailer())
        assert( result == "foo has been added with a stock of 3.") { result }
    }
}