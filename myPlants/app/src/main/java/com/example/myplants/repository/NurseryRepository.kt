package com.example.myplants.repository

import com.example.myplants.network.service.AuthService

class NurseryRepository (val nurseryService: AuthService) {
    suspend fun getNurseries() = nurseryService.allNurseries()
}