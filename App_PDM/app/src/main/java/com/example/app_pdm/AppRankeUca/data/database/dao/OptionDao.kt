package com.example.app_pdm.AppRankeUca.data.database.dao


import androidx.room.*
import com.example.app_pdm.AppRankeUca.data.database.entities.OptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Query("SELECT * FROM options")
    fun getAllOptions(): Flow<List<OptionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: OptionEntity)

    @Delete
    suspend fun deleteOption(option: OptionEntity)
}