package com.example.app_pdm.AppRankeUca.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.app_pdm.AppRankeUca.data.database.entities.QuestionEntity
import com.example.app_pdm.AppRankeUca.data.database.entities.QuestionWithOptions
import kotlinx.coroutines.flow.Flow

//Trae la lista de opciones
@Dao
interface QuestionDao {

    @Transaction//para que las lecturas pasen juntas y consistentes
    @Query("SELECT * FROM questions")
    fun getQuestionsWithOptions(): Flow<List<QuestionWithOptions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Delete
    suspend fun deleteQuestion(question: QuestionEntity)
}