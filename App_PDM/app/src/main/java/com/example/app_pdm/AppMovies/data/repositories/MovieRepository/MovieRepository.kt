package com.example.app_pdm.AppMovies.data.repositories.MovieRepository


import com.example.app_pdm.AppMovies.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieById(id: Int): Movie?
    suspend fun getNowPlayingMovies(): List<Movie>
}