package com.example.myplants.ui.newplant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myplants.DigitalApplication
import com.example.myplants.network.ApiResponse
import com.example.myplants.repository.CredentialsRepository
import com.example.myplants.ui.register.RegisterUiStatus
import com.example.myplants.ui.register.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

class NewPlantViewModel (private val repository: CredentialsRepository) : ViewModel() {
    val name = MutableLiveData("")
    val watermount = MutableLiveData("")
    val sunmount =  MutableLiveData("")
    val image = MutableLiveData("")
    val description = MutableLiveData("")

    private val _status = MutableLiveData<RegisterUiStatus>(RegisterUiStatus.Resume)
    val status: LiveData<RegisterUiStatus>
        get() = _status

    private fun newplPlant(name:String,watermount:String,sunmount:String,image:String,description:String){
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.newplant(name, watermount.toString().toInt(), sunmount.toString().toInt(), image,description)) {
                    is ApiResponse.Error -> RegisterUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> RegisterUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Succes -> RegisterUiStatus.Success
                }
            )
        }
    }

    fun onNewPlant() {
        if (!validateData()) {
            _status.value = RegisterUiStatus.ErrorWithMessage("Complete fields")
            return
        }

        newplPlant(name.value!!, watermount.value!!, sunmount.value!!, image.value!!, description.value!!)
    }
    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            watermount.value.isNullOrEmpty() -> return false
            sunmount.value.isNullOrEmpty() -> return false
            image.value == null -> return false
            description.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun clearStatus() {
        _status.value = RegisterUiStatus.Resume
    }
    fun clearData() {
        name.value = ""
        watermount.value = ""
        sunmount.value = ""
        image.value = ""
        description.value = ""
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DigitalApplication
                NewPlantViewModel(app.credentialsRepository)
            }
        }
    }

}