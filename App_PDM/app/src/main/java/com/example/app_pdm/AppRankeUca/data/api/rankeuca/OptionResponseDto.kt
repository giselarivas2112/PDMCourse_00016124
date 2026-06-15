package com.example.app_pdm.AppRankeUca.data.api.rankeuca

import com.pdmcourse2026.basictemplate.model.Option
import kotlinx.serialization.Serializable

@Serializable
data class OptionResponseDto(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int
)

fun OptionResponseDto.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
        votes = votes
    )
}