package com.example.myplants.repository

import com.example.myplants.data.model.PlantModel
import com.example.myplants.network.service.PlantService

class PlantRepository (val plantService: PlantService)  {
    suspend fun getPlant() = plantService.allPlants()
   // fun addPlant(newPlant: PlantModel) = PlantRepository.add(newPlant)
}