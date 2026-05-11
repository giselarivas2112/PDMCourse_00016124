package com.example.app_pdm.AppMovies.screens.MovieList


import androidx.lifecycle.ViewModel
import com.example.app_pdm.AppMovies.dummy.dummyMovies
import com.example.app_pdm.AppMovies.model.Movie

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieListViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    fun loadMovies() {
        _loading.value = true
        // Simulate loading movies from an API or database
        _movies.value = dummyMovies
        _loading.value = false
    }
}