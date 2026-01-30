package com.example.gymappadmin.features.auth.domain.models

data class UserModel(
    val username: String,
    val role: String = "Admin"
)