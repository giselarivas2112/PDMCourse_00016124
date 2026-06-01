package com.example.app_pdm.AppEjercicioClase


import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app_pdm.AppEjercicioClase.screens.PostList.PostListScreen

@Composable
fun PostApp() {
    val backStack = rememberNavBackStack(Routes.Posts)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Posts> {
                PostListScreen()
            }

        }
    )

}