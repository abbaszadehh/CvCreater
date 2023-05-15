package com.ayn.cvcreater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayn.cvcreater.databinding.CardEducationBinding
import com.ayn.cvcreater.model.ModelEducation

class EducationAdapter : RecyclerView.Adapter<EducationAdapter.EducationHolder>() {

    private val educationList = arrayListOf<ModelEducation>()
    var deleteItem : ((position : Int)->Unit)?= null
    var editItem : ((position : Int)->Unit)?= null

    fun onDeleteItem(listener : (position : Int)->Unit){
        deleteItem = listener
    }

    fun onEditItem(listener : (position : Int)->Unit){
        editItem = listener
    }

    inner class EducationHolder(private val binding: CardEducationBinding) :
        RecyclerView.ViewHolder(binding.root) {



        fun bind(item: ModelEducation, position: Int) {

           with(binding){
               university.setText("${item.university}")
               faculty.setText("${item.faculty}")
               degree.setText("${item.degree}")

               delete.setOnClickListener {
                   deleteItem?.invoke(position)

               }
               modify.setOnClickListener {
                   editItem?.invoke(position)
               }
           }

        }
    }

    fun updateList (list: List<ModelEducation>){
        educationList.clear()
        educationList.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationHolder {
        val layout  = CardEducationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EducationHolder(layout)
    }


    override fun onBindViewHolder(holder: EducationHolder, position: Int) {
        holder.bind(educationList.get(position),position)
    }

    override fun getItemCount(): Int {
        return educationList.size
    }
}