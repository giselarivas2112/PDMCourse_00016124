package com.example.app_pdm.AppRankeUca.data.api.rankeuca

import kotlinx.serialization.Serializable

@Serializable
data class VoteResponseDto(
    val ok: Boolean,
    val message: String
)