package com.example.myplants.data.model

import com.google.gson.annotations.SerializedName

data class PlantModel(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("wateramount") val watermount: Int,
    @SerializedName("sunamount") val sunamount: Int,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String
)