package com.example.myplants.network

sealed class ApiResponse<T> {
    data class Succes<T>(val data: T) : ApiResponse<T>()

    data class Error<T>(val exception: Exception) : ApiResponse<T>()

    data class ErrorWithMessage<T>(val message: String) : ApiResponse<T>()
}