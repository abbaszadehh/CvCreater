package com.ayn.cvcreater.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PdfEntity (

    @PrimaryKey
    val id: Int,
    val text : String
    )