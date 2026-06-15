package com.example.app_pdm.AppRankeUca.data.repositories

import com.pdmcourse2026.basictemplate.model.Option

interface VoteRepository {
    suspend fun getOptions(): Result<List<Option>>
    suspend fun vote(optionId: Int): Result<String>
}
