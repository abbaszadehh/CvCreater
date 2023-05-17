package com.ayn.cvcreater.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelEducation(

    var university : String,
    var faculty : String,
    var degree : String

) : Parcelable
