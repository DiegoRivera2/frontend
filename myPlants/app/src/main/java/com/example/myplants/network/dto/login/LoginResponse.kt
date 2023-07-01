package com.example.myplants.network.dto.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("msg") val message: String,
    @SerializedName("token") val token: String
)