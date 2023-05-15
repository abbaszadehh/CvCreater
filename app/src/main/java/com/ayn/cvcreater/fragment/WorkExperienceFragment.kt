package com.ayn.cvcreater.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayn.cvcreater.dialoq.WorkExpHelperDialog
import com.ayn.cvcreater.adapter.WorkExperienceAdapter
import com.ayn.cvcreater.WorkExperienceFragmentArgs
import com.ayn.cvcreater.WorkExperienceFragmentDirections
import com.ayn.cvcreater.viewModel.WorkExperienceViewModel
import com.ayn.cvcreater.databinding.FragmentWorkExperienceBinding
import com.ayn.cvcreater.model.ModelPersonal
import com.ayn.cvcreater.model.WorkAndPersonalDataModel

class WorkExperienceFragment : Fragment() {

    private lateinit var binding: FragmentWorkExperienceBinding
    private val args: WorkExperienceFragmentArgs by navArgs()
    private val modelPersonal: ModelPersonal by lazy { args.modelPersonal }
    private val viewModel: WorkExperienceViewModel by activityViewModels()
    private val workAdapter = WorkExperienceAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkExperienceBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRw()

        viewModel.list.observe(viewLifecycleOwner) {
            workAdapter.updateList(it)
        }

        workAdapter.onDeleteItem { position ->
            viewModel.deleteItem(position)
            viewModel.updateList()
        }

        workAdapter.onEditItem { position ->
            viewModel.modifyItem(position)
            WorkExpHelperDialog().show(childFragmentManager,"work")
        }

        binding.newWork.setOnClickListener {
            viewModel.modifyItem(null)
            WorkExpHelperDialog().show(childFragmentManager,"work")
        }
        binding.nextSave.setOnClickListener {
            val workModel  = WorkAndPersonalDataModel(modelPersonal,viewModel.workList.toList())
            val action =
                WorkExperienceFragmentDirections.actionWorkExperienceFragmentToEducationFragment(
                    workModel
                )
            findNavController().navigate(action)
        }

    }
    fun setRw() {
        with(binding.rwHome) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = workAdapter
        }
    }
    }