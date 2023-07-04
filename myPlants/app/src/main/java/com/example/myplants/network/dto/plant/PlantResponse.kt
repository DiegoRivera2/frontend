package com.example.myplants.network.dto.plant

import com.google.gson.annotations.SerializedName

data class PlantResponse (
    @SerializedName("msg") val message: String
)