package com.example.app_pdm.AppRankeUca

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data object Vote : Routes()

    @Serializable
    data object Result : Routes()

}
