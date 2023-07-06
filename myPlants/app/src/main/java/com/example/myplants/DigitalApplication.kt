package com.example.myplants

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.myplants.network.digitalapi.DigitaltInstance
import com.example.myplants.repository.CredentialsRepository
import com.example.myplants.repository.PlantRepository

class DigitalApplication : Application() {

    val plantRepository: PlantRepository by lazy {
        PlantRepository(DigitaltInstance.getPlantService())
    }

    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    private fun getAPIService() = with(DigitaltInstance) {
        setToken(getToken())
        getLoginService()
    }

    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}