package com.ayn.cvcreater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ayn.cvcreater.databinding.FragmentWorkExpHelperBinding

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
                binding.exitDate.setText(it.exitingDate)
            } ?: apply {

                binding.jobTitle.setText("")
                binding.companyName.setText("")
                binding.enteringDate.setText("")
                binding.exitDate.setText("")
            }
        }
        dialog?.setOnDismissListener {
            viewModel.addModel(null)
        }
    }
}