package com.ayn.cvcreater.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayn.cvcreater.model.AdditionalDataModel

@Database(
    entities = [AdditionalDataModel::class],
    version = 1,
    exportSchema = false
)
abstract class PdfDatabase : RoomDatabase() {
    abstract fun additionalDao(): AdditionalDao

    companion object {
        fun getDatabase(context: Context): PdfDatabase {
            return Room.databaseBuilder(context = context, PdfDatabase::class.java, "PDF")
                .fallbackToDestructiveMigration().build()
        }
    }
}