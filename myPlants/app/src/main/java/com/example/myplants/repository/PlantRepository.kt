package com.example.myplants.repository

import com.example.myplants.data.model.PlantModel

class PlantRepository (private val PlantRepository: MutableList<PlantModel>)  {
    fun getPlant()=PlantRepository
    fun addPlant(newPlant: PlantModel) = PlantRepository.add(newPlant)
}