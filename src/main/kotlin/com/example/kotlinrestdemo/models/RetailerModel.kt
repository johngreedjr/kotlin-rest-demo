package com.example.kotlinrestdemo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "RETAILERS")
data class Retailer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var retailerId : Long? = null,
    var retailerName : String? = null,
    var retailerStock : Int? = null
)