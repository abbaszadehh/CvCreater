package com.ayn.cvcreater.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity
@Parcelize
data class AdditionalDataModel(
    @PrimaryKey
    val id : Int,
    val persAndWorkAndEduModel : PersAndWorkAndEduModel,
    val additionalText : String
): Parcelable
