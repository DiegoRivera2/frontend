package com.example.myplants.ui.users.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myplants.DigitalApplication
import com.example.myplants.data.model.PlantModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.repository.PlantRepository
import com.example.myplants.repository.UsersRepository
import com.example.myplants.ui.plants.viewmodel.PlantsViewModel

class UsersViewModel (private val repository: UsersRepository): ViewModel() {
    var name  = MutableLiveData("")
    var email  = MutableLiveData("")
    var age  = MutableLiveData("")
    var position  = MutableLiveData("")
    var status = MutableLiveData("")

    suspend fun getUser() = repository.getUsers()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DigitalApplication
                UsersViewModel(app.userRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun setSelectedUser(users: UserModel){
        name.value = users.name
        email.value = users.email
        age.value = users.age.toString()
        position.value = users.position
    }
}