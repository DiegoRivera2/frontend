package com.example.myplants.data.model

import com.google.gson.annotations.SerializedName

class UserModel (
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("age") val age: Int,
    @SerializedName("position") val position: String
        )