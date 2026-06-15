package com.example.app_pdm.AppRankeUca.data.api.rankeuca

import kotlinx.serialization.Serializable

@Serializable
data class VoteRequestDto(
    val optionId: Int
)