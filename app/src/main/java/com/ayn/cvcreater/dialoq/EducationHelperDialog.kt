package com.ayn.cvcreater.dialoq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ayn.cvcreater.databinding.FragmentEducationHelperDialogBinding
import com.ayn.cvcreater.model.ModelEducation
import com.ayn.cvcreater.model.ModelWorkExperience
import com.ayn.cvcreater.viewModel.EducationViewModel

class EducationHelperDialog : DialogFragment() {

    private lateinit var binding: FragmentEducationHelperDialogBinding
    private val viewModel: EducationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationHelperDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.model.observe(viewLifecycleOwner) {
            it?.let {
                binding.faculty.setText(it.faculty)
                binding.university.setText(it.university)
                binding.degree.setText(it.degree)
            } ?: apply {
                binding.faculty.setText("")
                binding.university.setText("")
                binding.degree.setText("")
            }
        }
        binding.save.setOnClickListener {
            val item = viewModel.getCurrentItem()
            val faculty = binding.faculty.text.toString()
            val university = binding.university.text.toString()
            val degree = binding.degree.text.toString()

            item?.let {

                item.faculty = faculty
                item.university = university
                item.degree = degree
            } ?: apply {
                val newItem = ModelEducation(
                    university,
                    faculty,
                    degree
                )
                viewModel.eduList.add(newItem)
            }
            viewModel.updateList()
            dialog?.dismiss()

        }
        dialog?.setOnDismissListener {
            viewModel.modifyItem(null)
        }


    }

}