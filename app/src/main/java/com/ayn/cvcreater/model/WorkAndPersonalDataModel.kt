package com.ayn.cvcreater.model

import android.os.Parcelable
import com.ayn.cvcreater.model.ModelPersonal
import com.ayn.cvcreater.model.ModelWorkExperience
import kotlinx.parcelize.Parcelize
@Parcelize
data class WorkAndPersonalDataModel (
    val modelPersonal : ModelPersonal,
    val workList : List<ModelWorkExperience>
        ) : Parcelable

