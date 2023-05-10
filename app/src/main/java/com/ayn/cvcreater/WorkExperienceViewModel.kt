package com.ayn.cvcreater

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkExperienceViewModel : ViewModel() {
    private val _model = MutableLiveData<ModelWorkExperience?>()
    val model: LiveData<ModelWorkExperience?>
        get() = _model

    fun addModel(item: ModelWorkExperience?) {
        _model.value = item
    }
}