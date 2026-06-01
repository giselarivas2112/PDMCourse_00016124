package com.example.app_pdm.AppEjercicioClase

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{

    @Serializable
    data object Posts : Routes()

}