package com.example.app_pdm.AppRankeUca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app_pdm.AppRankeUca.screens.Options.OptionsScreen
import com.example.app_pdm.AppRankeUca.screens.home.HomeScreen


@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    navigateToOptions = { backStack.add(Routes.Options) }
                )
            }

            entry<Routes.Options> {
                OptionsScreen(
                    navigateToHome = { backStack.add(Routes.Home) }
                )
            }


        },


        )


}