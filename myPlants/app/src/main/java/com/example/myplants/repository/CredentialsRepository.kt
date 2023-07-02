package com.example.myplants.repository

import com.example.myplants.network.ApiResponse
import com.example.myplants.network.dto.login.LoginRequest
import com.example.myplants.network.dto.login.LoginResponse
import com.example.myplants.network.dto.register.RegisterRequest
import com.example.myplants.network.dto.register.RegisterResponse
import com.example.myplants.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    suspend fun login(email: String, password: String): ApiResponse<String> {
        try {

            val response:LoginResponse =
                api.login(LoginRequest(email, password))
            return ApiResponse.Succes(response.token)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(name: String, email: String, password: String, age:Int, position:String): ApiResponse<String> {
        try {

            val response: RegisterResponse =
                api.register(RegisterRequest(name, email, password, age, position))
            return ApiResponse.Succes(response.message)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid name, email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }
}