package com.ayn.cvcreater.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayn.cvcreater.model.AdditionalDataModel

@Dao
interface AdditionalDao {
    @Query("SELECT * FROM PdfEntity")
     fun getAll()

    @Query("SELECT * FROM PdfEntity Where id =:id")
    fun getById(id : Int)

    @Query("DELETE FROM PdfEntity Where id =:id")
    fun delete(id : Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: PdfEntity)
}