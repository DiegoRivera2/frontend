package com.example.myplants.network.dto.plant

data class PlantRequest (
    val name : String,
    val wateramount: Float,
    val sunamount : Int,
    val image: String,
    val description: String)
