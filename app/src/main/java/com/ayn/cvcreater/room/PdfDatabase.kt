package com.ayn.cvcreater.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayn.cvcreater.model.AdditionalDataModel

@Database(
    entities = [PdfEntity::class],
    version = 3,
    exportSchema = false
)
abstract class PdfDatabase : RoomDatabase() {
    abstract fun additionalDao(): AdditionalDao

    companion object {
        private var INSTANCE: PdfDatabase? = null

        fun getDatabase(context: Context): PdfDatabase?{
            if (INSTANCE == null){
                synchronized(PdfDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        PdfDatabase::class.java,
                        "ytr")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}

fun generateDb(context : Context): PdfDatabase?{
    return Room.databaseBuilder(context.applicationContext,
        PdfDatabase::class.java,
        "ytr")
        .fallbackToDestructiveMigration()
        .build()
}