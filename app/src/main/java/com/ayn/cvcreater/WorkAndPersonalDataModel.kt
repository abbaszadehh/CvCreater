package com.ayn.cvcreater

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class WorkAndPersonalDataModel (
    val modelPersonal : ModelPersonal,
    val workList : List<ModelWorkExperience>
        ) : Parcelable

