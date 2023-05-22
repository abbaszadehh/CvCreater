package com.ayn.cvcreater.dialoq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ayn.cvcreater.databinding.FragmentWorkExpHelperBinding
import com.ayn.cvcreater.model.ModelWorkExperience
import com.ayn.cvcreater.viewModel.WorkExperienceViewModel

class WorkExpHelperDialog : DialogFragment() {

    private lateinit var binding: FragmentWorkExpHelperBinding
    private val viewModel: WorkExperienceViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkExpHelperBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.model.observe(viewLifecycleOwner) {
            it?.let {
                binding.jobTitle.setText(it.jobTitle)
                binding.companyName.setText(it.companyName)
                binding.enteringDate.setText(it.enteringDate)
                binding.exitingDate.setText(it.exitingDate)
            } ?: apply {
                binding.jobTitle.setText("")
                binding.companyName.setText("")
                binding.enteringDate.setText("")
                binding.exitingDate.setText("")
            }
        }

        binding.next.setOnClickListener {
            val item = viewModel.getCurrentItem()
            val jobTitle = binding.jobTitle.text.toString()
            val companyName = binding.companyName.text.toString()
            val enteringDate = binding.enteringDate.text.toString()
            val exitDate = binding.exitingDate.text.toString()
            item?.let {
                item.companyName = companyName
                item.jobTitle = jobTitle
                item.enteringDate = enteringDate
                item.exitingDate = exitDate
            } ?: apply {
                val newItem = ModelWorkExperience(
                    jobTitle,
                    companyName,
                    enteringDate,
                    exitDate
                )
                viewModel.workList.add(newItem)
            }
            viewModel.updateList()
            dialog?.dismiss()

        }
        dialog?.setOnDismissListener {
            viewModel.modifyItem(null)
        }
    }
}