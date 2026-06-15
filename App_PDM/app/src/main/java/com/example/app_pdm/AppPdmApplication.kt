package com.example.app_pdm


import android.app.Application
import com.example.app_pdm.AppRankeUca.data.AppProvider

class AppPdmApplication : Application() {
    val appProvider by lazy { AppProvider(this) }
}