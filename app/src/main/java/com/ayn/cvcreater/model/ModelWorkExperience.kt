package com.ayn.cvcreater.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelWorkExperience(
    var jobTitle : String,
    var companyName : String,
    var enteringDate : String,
    var exitingDate : String
) : Parcelable
