package com.example.app_pdm.AppEjercicioClase.data.api.posts

import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponseDto(
    val id: Int,
    val title: String,
    val body:String,
    val userId: Int,


)