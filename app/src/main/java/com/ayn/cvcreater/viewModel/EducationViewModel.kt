package com.ayn.cvcreater.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayn.cvcreater.model.ModelEducation

class EducationViewModel : ViewModel() {

    val eduList = arrayListOf<ModelEducation>()
    private var modifiedIndex : Int? = null

    fun getCurrentItem() : ModelEducation?{
        return modifiedIndex?.let {
            eduList[it]
        }
    }

    private val _model = MutableLiveData<ModelEducation?>()
    val model: LiveData<ModelEducation?>
        get() = _model

    private val _list = MutableLiveData<List<ModelEducation>>()
    val list: LiveData<List<ModelEducation>>
        get() = _list

    fun modifyItem(index: Int?){
        modifiedIndex = index
        index?.let {
            _model.value = eduList[index]
        }?: apply {
            _model.value = null
        }
    }

    fun deleteItem(index: Int){
        eduList.removeAt(index)
    }

    fun updateList(){
        _list.value= eduList
    }
}