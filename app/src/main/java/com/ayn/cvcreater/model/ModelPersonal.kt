package com.ayn.cvcreater.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelPersonal  (
    val name : String,
    val surname : String,
    val dob : String,
    val address : String,
    val phone : String,
    val photo : String?,
    val email : String,
    val socialStatus : String,
    val description : String
): Parcelable
