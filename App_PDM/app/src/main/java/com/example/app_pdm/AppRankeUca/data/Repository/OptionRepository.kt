package com.example.app_pdm.AppRankeUca.data.Repository


import com.example.app_pdm.AppRankeUca.data.model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(questionId: Int): Flow<List<Option>>
    suspend fun addOption(name: String, imageUrl: String, questionId: Int)
    suspend fun deleteOption(option: Option)
}