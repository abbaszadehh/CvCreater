package com.ayn.cvcreater.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersAndWorkAndEduModel(
    val workAndPersonalDataModel: WorkAndPersonalDataModel,
    val eduList : List<ModelEducation>
): Parcelable
