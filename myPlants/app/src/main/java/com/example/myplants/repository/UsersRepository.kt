package com.example.myplants.repository

import com.example.myplants.network.service.AuthService
import com.example.myplants.network.service.PlantService

class UsersRepository(val userService: AuthService) {
    suspend fun getUsers() = userService.allUsers()
}