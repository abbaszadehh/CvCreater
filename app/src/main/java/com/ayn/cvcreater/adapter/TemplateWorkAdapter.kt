package com.ayn.cvcreater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayn.cvcreater.databinding.TempWorkCardBinding
import com.ayn.cvcreater.model.ModelWorkExperience

class TemplateWorkAdapter : RecyclerView.Adapter<TemplateWorkAdapter.WorkExperinceHolder>() {

    private val workList = arrayListOf<ModelWorkExperience>()

    inner class WorkExperinceHolder(private val binding : TempWorkCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (item : ModelWorkExperience){
            with(binding){
                jobTitle.text = "job title: ${item.jobTitle}"
                compName.text = item.companyName
                enteringDate.text = item.enteringDate
                exitingDate.text = item.exitingDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkExperinceHolder {
        val layout = TempWorkCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WorkExperinceHolder(layout)
    }

    override fun onBindViewHolder(holder: WorkExperinceHolder, position: Int)  = holder.bind(workList.get(position))

    override fun getItemCount(): Int {
        return workList.size
    }

    fun updateList(item: List<ModelWorkExperience>){
        workList.clear()
        workList.addAll(item)
        notifyDataSetChanged()
    }
}