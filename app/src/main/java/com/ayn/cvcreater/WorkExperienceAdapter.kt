package com.ayn.cvcreater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayn.cvcreater.databinding.WorkCardBinding


class WorkExperienceAdapter : RecyclerView.Adapter<WorkExperienceAdapter.WorkExperienceHolder>(){

    private val workList = arrayListOf<ModelWorkExperience>()

    inner class WorkExperienceHolder(private val binding: WorkCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (item : ModelWorkExperience){
            with(binding){
                jobTitle.setText( "${item.jobTitle}")
                companyName.setText("${item.companyName}")
                enteringDate.setText("${item.enteringDate}")
                exitDate.setText("${item.exitingDate}")
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkExperienceHolder {
        val layout = WorkCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WorkExperienceHolder(layout)
    }


    override fun onBindViewHolder(holder: WorkExperienceHolder, position: Int) = holder.bind(workList.get(position))

    override fun getItemCount(): Int {
        return workList.size
    }

    fun updateList(list : List<ModelWorkExperience>){
        workList.clear()
        workList.addAll(list)
        notifyDataSetChanged()
    }
}