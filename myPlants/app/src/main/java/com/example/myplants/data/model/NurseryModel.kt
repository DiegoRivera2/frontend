package com.example.myplants.data.model

import com.google.gson.annotations.SerializedName

class NurseryModel (
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("video") val video: String,
    @SerializedName("description") val description: String,
    @SerializedName("ubication") val ubucation: String
)