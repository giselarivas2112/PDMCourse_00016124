package com.example.app_pdm.AppRankeUca.data.model

import com.example.app_pdm.AppRankeUca.data.database.entities.QuestionEntity

data class Question(
    val id: Int = 0,
    val title: String,
    val optionCount: Int = 0,
)

fun Question.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        title = title,
    )
}