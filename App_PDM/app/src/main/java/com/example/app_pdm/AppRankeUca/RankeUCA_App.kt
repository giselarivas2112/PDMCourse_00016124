package com.example.app_pdm.AppRankeUca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdmcourse2026.basictemplate.screens.Resultados.ResultsScreen
import com.pdmcourse2026.basictemplate.screens.Votacion.VoteScreen
import com.pdmcourse2026.basictemplate.screens.home.HomeScreen

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    navigateToVote = { backStack.add(Routes.Vote) },
                    navigateToResult = { backStack.add(Routes.Result) }
                )
            }
            entry<Routes.Vote> {
                VoteScreen(
                    navigateToResults = { backStack.add(Routes.Result) }
                )
            }
            entry<Routes.Result> {
                ResultsScreen(
                    navigateBack = { backStack.removeLastOrNull() }
                )
            }


        },


        )


}