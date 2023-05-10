package com.ayn.cvcreater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayn.cvcreater.databinding.WorkCardBinding


class WorkExperienceAdapter : RecyclerView.Adapter<WorkExperienceAdapter.WorkExperienceHolder>(){

    private val workList = arrayListOf<ModelWorkExperience>()

    var deleteItem : ((position : Int)->Unit)?= null
    var editItem : ((position : Int)->Unit)?= null

    fun onDeleteItem(listener : (position : Int)->Unit){
        deleteItem = listener
    }

    fun onEditItem(listener : (position : Int)->Unit){
        editItem = listener
    }

    inner class WorkExperienceHolder(private val binding: WorkCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (item : ModelWorkExperience,position: Int){
            with(binding){
                jobTitle.isEnabled = false
                companyName.isEnabled = false
                enteringDate.isEnabled = false
                exitDate.isEnabled = false

                jobTitle.setText( "${item.jobTitle}")
                companyName.setText("${item.companyName}")
                enteringDate.setText("${item.enteringDate}")
                exitDate.setText("${item.exitingDate}")

                delete.setOnClickListener {
                    deleteItem?.invoke(position)
                }

                modify.setOnClickListener {
                    editItem?.invoke(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkExperienceHolder {
        val layout = WorkCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WorkExperienceHolder(layout)
    }


    override fun onBindViewHolder(holder: WorkExperienceHolder, position: Int) = holder.bind(workList.get(position),position)

    override fun getItemCount(): Int {
        return workList.size
    }

    fun updateList(list : List<ModelWorkExperience>){
        workList.clear()
        workList.addAll(list)
        notifyDataSetChanged()
    }
}