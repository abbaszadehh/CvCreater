package com.ayn.cvcreater.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayn.cvcreater.model.AdditionalDataModel

@Dao
interface AdditionalDao {
    @Query("SELECT * FROM PdfEntity")
    suspend fun getAll() : List<PdfEntity>

    @Query("SELECT * FROM PdfEntity Where id =:id")
    suspend fun getById(id : Int): PdfEntity

    @Query("DELETE FROM PdfEntity Where id =:id")
    fun delete(id : Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: PdfEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userInsert: PdfEntity)

}