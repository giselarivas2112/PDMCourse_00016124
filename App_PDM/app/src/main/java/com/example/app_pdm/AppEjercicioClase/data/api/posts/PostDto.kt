package com.example.app_pdm.AppEjercicioClase.data.api.posts


import com.example.app_pdm.AppEjercicioClase.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)

fun PostDto.toModel(): Post {
    return Post(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}

