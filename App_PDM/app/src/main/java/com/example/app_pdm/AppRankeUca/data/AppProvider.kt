package com.example.app_pdm.AppRankeUca.data

import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepository
import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepositoryImpl
import com.example.app_pdm.AppRankeUca.data.database.AppDatabase


import android.content.Context
import com.example.app_pdm.AppRankeUca.data.Repository.QuestionRepository
import com.example.app_pdm.AppRankeUca.data.Repository.QuestionRepositoryImpl


class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)

    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()


    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}