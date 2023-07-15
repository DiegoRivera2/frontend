package com.example.myplants.network.service

import com.example.myplants.data.model.NurseryModel
import com.example.myplants.data.model.PlantModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.network.dto.login.LoginRequest
import com.example.myplants.network.dto.login.LoginResponse
import com.example.myplants.network.dto.newplant.NewPlantRequest
import com.example.myplants.network.dto.newplant.NewPlantResponse
import com.example.myplants.network.dto.register.RegisterRequest
import com.example.myplants.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("/login")
    suspend fun login(@Body credentiales: LoginRequest): LoginResponse

    @POST("plantsApi/users")
    suspend fun register(@Body credentiales: RegisterRequest): RegisterResponse

    @POST("plantsApi/plants")
    suspend fun newplant(@Body credentiales: NewPlantRequest): NewPlantResponse

    @GET("plantsApi/users")
    suspend fun allUsers(): List<UserModel>

    @GET("plantsApi/nursery")
    suspend fun allNurseries(): List<NurseryModel>
}