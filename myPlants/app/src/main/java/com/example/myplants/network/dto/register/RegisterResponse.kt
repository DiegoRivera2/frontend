package com.example.myplants.network.dto.register

import com.google.gson.annotations.SerializedName

class RegisterResponse (
    val name: String,
    val email: String,
    val password: String,
    val language: String,
    val contry: String
)