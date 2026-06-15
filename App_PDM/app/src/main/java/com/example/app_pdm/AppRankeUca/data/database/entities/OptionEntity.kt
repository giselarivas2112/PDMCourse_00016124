package com.example.app_pdm.AppRankeUca.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.app_pdm.AppRankeUca.data.model.Option

@Entity(tableName = "options")
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
)

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
}

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
}