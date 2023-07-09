package com.example.myplants.network.digitalapi

import com.example.myplants.network.service.AuthService
import com.example.myplants.network.service.PlantService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://plantsapipdm.homes/"

object DigitaltInstance {

    private var TOKEN = ""

    fun setToken(token: String) {
        this.TOKEN = token
    }

    //retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun getPlantService(): PlantService {
        return retrofit.create(PlantService::class.java)
    }

}