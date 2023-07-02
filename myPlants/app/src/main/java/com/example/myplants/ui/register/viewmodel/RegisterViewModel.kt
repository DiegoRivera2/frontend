package com.example.myplants.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myplants.DigitalApplication
import com.example.myplants.network.ApiResponse
import com.example.myplants.repository.CredentialsRepository
import com.example.myplants.ui.register.RegisterUiStatus
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: CredentialsRepository) : ViewModel()  {
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var age = MutableLiveData("")
    var position = MutableLiveData("Normal user")

    private val _status = MutableLiveData<RegisterUiStatus>(RegisterUiStatus.Resume)
    val status: LiveData<RegisterUiStatus>
        get() = _status

    private fun register(name: String, email: String, password: String, age: String, position:String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.register(name, email, password, age.toString().toInt(),position)) {
                    is ApiResponse.Error -> RegisterUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> RegisterUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Succes -> RegisterUiStatus.Success
                }
            )
        }
    }

    fun onRegister() {
        if (!validateData()) {
            _status.value = RegisterUiStatus.ErrorWithMessage("Complete fields")
            return
        }

        register(name.value!!, email.value!!, password.value!!, age.value!!, position.value!!)
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
            age.value == null -> return false
            position.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStatus() {
        _status.value = RegisterUiStatus.Resume
    }
    fun clearData() {
        name.value = ""
        email.value = ""
        password.value = ""
        age.value = ""
        position.value = ""
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as DigitalApplication
                RegisterViewModel(app.credentialsRepository)
            }
        }
    }

}