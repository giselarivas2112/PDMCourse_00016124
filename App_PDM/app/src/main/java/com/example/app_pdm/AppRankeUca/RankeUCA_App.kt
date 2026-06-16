package com.example.app_pdm.AppRankeUca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app_pdm.AppRankeUca.screens.Options.OptionsScreen
import com.example.app_pdm.AppRankeUca.screens.Question.QuestionsScreen
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
                    navigateToQuestions = { backStack.add(Routes.Questions) }
                )
            }

            entry<Routes.Options> { entry ->
                OptionsScreen(
                    questionId = entry.questionId,
                    navigateToBack = { backStack.removeLastOrNull() }
                )
            }


            entry<Routes.Questions> {
                QuestionsScreen(
                    onQuestionClick = { questionId -> backStack.add(Routes.Options(questionId)) },
                    navigateToHome = { backStack.removeLastOrNull() }
                )
            }


        },


        )


}