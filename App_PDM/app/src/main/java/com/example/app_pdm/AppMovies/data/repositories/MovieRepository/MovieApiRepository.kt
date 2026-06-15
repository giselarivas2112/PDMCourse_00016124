package com.example.app_pdm.AppMovies.data.repositories.MovieRepository


import com.example.app_pdm.AppMovies.data.api.KtorClient_V4
import com.example.app_pdm.AppMovies.data.api.Movies.GetMoviesResponseDto
import com.example.app_pdm.AppMovies.data.api.Movies.MovieDto
import com.example.app_pdm.AppMovies.data.api.Movies.toModel
import com.example.app_pdm.AppMovies.model.Movie
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiRepository : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        val response: GetMoviesResponseDto = KtorClient_V4.client.get("movie/popular") {
            parameter("language", "es-ES")
            parameter("page", 1)
        }.body()

        return response.results.map { movieDto -> movieDto.toModel() }
    }

    override suspend fun getMovieById(id: Int): Movie? {
        val response: MovieDto = KtorClient_V4.client.get("movie/$id") {
            parameter("language", "es-ES")
        }.body()

        return response.toModel()
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        val response: GetMoviesResponseDto = KtorClient_V4.client.get("movie/now_playing") {
            parameter("language", "es-ES")
            parameter("page", 1)
        }.body()
        return response.results.map { it.toModel() }
    }

}