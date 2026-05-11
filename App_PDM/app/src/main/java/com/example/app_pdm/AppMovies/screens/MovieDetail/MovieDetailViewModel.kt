package com.example.app_pdm.AppMovies.screens.MovieDetail

import androidx.lifecycle.ViewModel
import com.example.app_pdm.AppMovies.dummy.dummyMovies
import com.example.app_pdm.AppMovies.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieDetailViewModel : ViewModel() {

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie = _movie.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun loadMovie(movieId: Int) {

        _loading.value = true

        _movie.value = dummyMovies.find { it.id == movieId }

        _loading.value = false
    }
}