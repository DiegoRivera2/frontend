package com.example.myplants.network.dto.login
import com.google.gson.annotations.SerializedName

data class LoginRequest (
    val email: String,
    val password: String
)