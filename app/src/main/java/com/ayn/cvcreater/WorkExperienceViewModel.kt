package com.ayn.cvcreater

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkExperienceViewModel : ViewModel() {
    val workList = arrayListOf<ModelWorkExperience>()
    private var modifiedIndex : Int? = null

    fun getCurrentItem() :ModelWorkExperience?{
        return modifiedIndex?.let {
            workList[it]
        }
    }

    private val _model = MutableLiveData<ModelWorkExperience?>()
    val model: LiveData<ModelWorkExperience?>
        get() = _model

    private val _list = MutableLiveData<List<ModelWorkExperience>>()
    val list: LiveData<List<ModelWorkExperience>>
        get() = _list

    fun modifyItem(index: Int?){
        modifiedIndex = index
        index?.let {
            _model.value = workList[index]
        }?: apply {
            _model.value = null
        }
    }

    fun deleteItem(index: Int){
        workList.removeAt(index)
    }

    fun updateList(){
        _list.value= workList
    }
}