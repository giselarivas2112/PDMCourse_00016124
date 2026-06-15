package com.example.app_pdm.AppRankeUca.data.Repository


import com.example.app_pdm.AppRankeUca.data.model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(): Flow<List<Option>>
    suspend fun addOption(option: Option)
    suspend fun deleteOption(option: Option)
}