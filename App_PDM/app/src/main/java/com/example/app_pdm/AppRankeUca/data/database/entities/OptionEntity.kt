package com.example.app_pdm.AppRankeUca.data.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.app_pdm.AppRankeUca.data.model.Option

@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("questionId")]//ess un indice de la llave foranea
)
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int,
)

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}