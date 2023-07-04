package com.example.myplants.data


import com.example.myplants.network.dto.plant.PlantRequest
import com.example.myplants.network.dto.plant.PlantResponse
import retrofit2.http.Body
import retrofit2.http.GET


interface PlantDao {
    @GET("/plantsApi/plants")
    suspend fun login(@Body credentiales: PlantRequest): PlantResponse
}