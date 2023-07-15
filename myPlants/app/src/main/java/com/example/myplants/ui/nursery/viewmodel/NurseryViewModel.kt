package com.example.myplants.ui.nursery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myplants.DigitalApplication
import com.example.myplants.data.model.NurseryModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.repository.NurseryRepository
import com.example.myplants.repository.UsersRepository
import com.example.myplants.ui.users.viewmodel.UsersViewModel

class NurseryViewModel  (private val repository: NurseryRepository): ViewModel(){
    var name  = MutableLiveData("")
    var video  = MutableLiveData("")
    var description  = MutableLiveData("")
    var ubication  = MutableLiveData("")

    suspend fun getNursery() = repository.getNurseries()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DigitalApplication
                NurseryViewModel(app.nurseryRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun setSelectedUser(nursery: NurseryModel){
        name.value = nursery.name
        video.value = nursery.video
        description.value = nursery.description
        ubication.value = nursery.ubucation
    }
}