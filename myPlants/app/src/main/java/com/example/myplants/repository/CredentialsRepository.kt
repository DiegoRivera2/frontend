package com.example.myplants.repository

import com.example.myplants.network.ApiResponse
import com.example.myplants.network.dto.login.LoginRequest
import com.example.myplants.network.dto.login.LoginResponse
import com.example.myplants.network.dto.newplant.NewPlantRequest
import com.example.myplants.network.dto.newplant.NewPlantResponse
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


    //Creando un nuevo usuario ->se llama atraves de RegisterViewModel

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


    //Creando una nuevo registro de plantas ->se llama a traves de NewPlantViewModel
    suspend fun newplant(name:String, wateramount:Int,sunamount:Int,image:String,description:String): ApiResponse<String> {
        try{
            val response: NewPlantResponse =
                api.newplant(NewPlantRequest(name, wateramount, sunamount, image, description))
            return ApiResponse.Succes(response.message)
        }catch (e: HttpException){
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid data")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }
}