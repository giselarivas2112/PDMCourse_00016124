package com.example.app_pdm.AppMovies.screens.MovieNowPlaying



import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_pdm.AppMovies.AppScaffold
import com.example.app_pdm.AppMovies.components.MovieItem

@Composable
fun NowPlayingScreen(
    navigateToDetail: (Int) -> Unit,
    navigateToBack: () ->Unit,
    viewModel: NowPlayingViewModel = viewModel()
) {
    val movies by viewModel.movies.collectAsState()
    val loading by viewModel.loading.collectAsState()

    if (loading) {
        AppScaffold(title = "En Cartelera") { padding ->
            CircularProgressIndicator(modifier = Modifier.padding(padding))
        }
        return
    }

    AppScaffold(title = "En Cartelera") { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Button(
                    onClick = navigateToBack
                ) {
                    Text("atras")
                }
            }
            items(movies) { movie ->
                MovieItem(
                    movie = movie,
                    onClick = { navigateToDetail(movie.id) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}