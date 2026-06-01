package com.example.app_pdm.AppEjercicioClase.data.repositories

import com.example.app_pdm.AppEjercicioClase.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun createPost(title:String, body:String): Result<Post>
}