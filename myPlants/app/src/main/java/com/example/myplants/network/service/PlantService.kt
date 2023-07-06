package com.example.myplants.network.service


import com.example.myplants.data.model.PlantModel
import retrofit2.http.GET


interface PlantService {
    @GET("/plantsApi/plants")
    suspend fun allPlants(): List<PlantModel>
}