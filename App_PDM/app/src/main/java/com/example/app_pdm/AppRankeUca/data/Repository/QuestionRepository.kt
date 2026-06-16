package com.example.app_pdm.AppRankeUca.data.Repository

import com.example.app_pdm.AppRankeUca.data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun addQuestion(title: String)
    suspend fun deleteQuestion(question: Question)
}