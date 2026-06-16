package com.example.app_pdm.AppRankeUca.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.app_pdm.AppRankeUca.data.model.Question

//Para traer una pregunta junto con todas sus opciones pero no es una tabla como tal
data class QuestionWithOptions(
    @Embedded val question: QuestionEntity,//mete las preguntas dentro de este paquete
    @Relation(//le dice a Room como encontrar sus opciones
        parentColumn = "id",
        entityColumn = "questionId"
    )
    val options: List<OptionEntity>
)

fun QuestionWithOptions.toModel(): Question {
    return Question(
        id = question.id,
        title = question.title,
        optionCount = options.size,
    )
}