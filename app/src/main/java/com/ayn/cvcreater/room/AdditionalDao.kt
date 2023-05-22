package com.ayn.cvcreater.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayn.cvcreater.model.AdditionalDataModel

@Dao
interface AdditionalDao {
    @Query("SELECT * FROM AdditionalDataModel")
     fun getAll()

    @Query("SELECT * FROM AdditionalDataModel Where id =:id")
    fun getById(id : Int)

    @Query("DELETE FROM AdditionalDataModel Where id =:id")
    fun delete(id : Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: AdditionalDataModel)
}