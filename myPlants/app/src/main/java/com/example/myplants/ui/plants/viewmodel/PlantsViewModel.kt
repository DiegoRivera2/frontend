package com.example.myplants.ui.plants.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myplants.DigitalApplication
import com.example.myplants.data.model.PlantModel
import com.example.myplants.repository.PlantRepository

class PlantsViewModel (private val repository: PlantRepository): ViewModel() {
    var name  = MutableLiveData("")
    var wateramount  = MutableLiveData("")
    var sunamount  = MutableLiveData("")
    var image  = MutableLiveData("")
    var description  = MutableLiveData("")
    var status = MutableLiveData("")

    suspend fun getFood() = repository.getPlant()
    fun addFood(food: PlantModel)  {
        //repository.addPlant(food)
    }
    private fun validarData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            wateramount.value.isNullOrEmpty()->return false
            sunamount.value.isNullOrEmpty()->return false
            image.value.isNullOrEmpty()->return false
            description.value.isNullOrEmpty()->return false
        }
        return true
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as DigitalApplication
                PlantsViewModel(app.plantRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
    fun clearData(){
        name.value = ""
        description.value = ""
        wateramount.value = ""
        sunamount.value = ""
        image.value = ""
    }
    fun setSelectedPlant(plant:PlantModel){
        name.value = plant.name
        wateramount.value = plant.watermount.toString()
        sunamount.value = plant.sunamount.toString()
        image.value = plant.image
        description.value = plant.description
    }

}