package com.example.app_pdm.AppRankeUca.data

import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepository
import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepositoryImpl
import com.example.app_pdm.AppRankeUca.data.database.AppDatabase


import android.content.Context


class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}