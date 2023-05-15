package com.ayn.cvcreater.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelEducation(

    val university : String,
    val faculty : String,
    val degree : String

) : Parcelable
