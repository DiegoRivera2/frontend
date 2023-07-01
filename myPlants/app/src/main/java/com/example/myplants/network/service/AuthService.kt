package com.example.myplants.network.service

import com.example.myplants.network.dto.login.LoginRequest
import com.example.myplants.network.dto.login.LoginResponse
import com.example.myplants.network.dto.register.RegisterRequest
import com.example.myplants.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/login")
    suspend fun login(@Body credentiales: LoginRequest): LoginResponse

    @POST("api/auth/register")
    suspend fun register(@Body credentiales: RegisterRequest): RegisterResponse
}