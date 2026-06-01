package com.example.app_pdm.AppEjercicioClase.screens.PostList


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_pdm.AppEjercicioClase.data.repositories.PostApiRepository
import com.example.app_pdm.AppEjercicioClase.data.repositories.PostRepository
import com.example.app_pdm.AppEjercicioClase.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.onFailure

class PostListViewModel : ViewModel() {

    private val postRepository: PostRepository = PostApiRepository()

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    // estado extra para cuando se está enviando el POST
    private val _sending = MutableStateFlow(false)
    val sending = _sending.asStateFlow()

    // estado para mostrar éxito al crear
    private val _createSuccess = MutableStateFlow(false)
    val createSuccess = _createSuccess.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _error.value = null
            _loading.value = true
            postRepository.getPosts()
                .onSuccess { _posts.value = it }
                .onFailure { _error.value = "Error al cargar los posts" }
            _loading.value = false
        }
    }

    fun createPost(title: String, body: String) {
        viewModelScope.launch {
            _error.value = null
            _sending.value = true
            postRepository.createPost(title, body)
                .onSuccess { newPost ->
                    _posts.value = listOf(newPost) + _posts.value
                    _createSuccess.value = true
                }
                .onFailure { _error.value = "Error al crear el post" }
            _sending.value = false
        }
    }

    fun resetCreateSuccess() {
        _createSuccess.value = false
    }
}