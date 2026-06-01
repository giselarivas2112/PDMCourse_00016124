package com.example.app_pdm.AppEjercicioClase.data.repositories

import com.example.app_pdm.AppEjercicioClase.model.Post
import com.example.app_pdm.AppEjercicioClase.data.api.KtorClientTwo
import com.example.app_pdm.AppEjercicioClase.data.api.posts.PostDto
import com.example.app_pdm.AppEjercicioClase.data.api.posts.toModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlin.collections.map

class PostApiRepository : PostRepository {

    override suspend fun getPosts(): Result<List<Post>> {
        try {
            val response: List<PostDto> = KtorClientTwo.client
                .get("posts")
                .body()
            return Result.success(response.map { it.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun createPost(title: String, body: String): Result<Post> {
        try {
            val response: PostDto = KtorClientTwo.client
                .post("posts") {
                    contentType(ContentType.Application.Json)
                    setBody(
                        PostDto(
                            id = 0,
                            userId = 1,
                            title = title,
                            body = body
                        )
                    )
                }.body()
            return Result.success(response.toModel())
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}