package com.ayn.cvcreater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayn.cvcreater.databinding.TempEduCardBinding
import com.ayn.cvcreater.model.ModelEducation

class TempEduAdapter : RecyclerView.Adapter<TempEduAdapter.EduCardHolder>() {

    private val eduList = arrayListOf<ModelEducation>()

    inner class EduCardHolder(private val binding: TempEduCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelEducation) {
            with(binding) {
                faculty.text = "Faculty : ${item.faculty}"
                university.text = "University : ${item.university}"
                degree.text = "Degree : ${item.degree}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EduCardHolder {
        val layout = TempEduCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EduCardHolder(layout)
    }


    override fun onBindViewHolder(holder: EduCardHolder, position: Int) =
        holder.bind(eduList.get(position))

    override fun getItemCount(): Int {
        return eduList.size
    }

    fun updateList(list: List<ModelEducation>) {
        eduList.clear()
        eduList.addAll(list)
        notifyDataSetChanged()
    }
}