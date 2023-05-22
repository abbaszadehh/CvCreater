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
import com.ayn.cvcreater.adapter.EducationAdapter
import com.ayn.cvcreater.databinding.FragmentEducationBinding
import com.ayn.cvcreater.dialoq.EducationHelperDialog
import com.ayn.cvcreater.model.PersAndWorkAndEduModel
import com.ayn.cvcreater.model.WorkAndPersonalDataModel
import com.ayn.cvcreater.viewModel.EducationViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EducationFragment : Fragment() {

    private lateinit var binding: FragmentEducationBinding
    private val args: EducationFragmentArgs by navArgs()
    private val model: WorkAndPersonalDataModel by lazy { args.modelWork }
    private val viewModel: EducationViewModel by activityViewModels()
    private val educationAdapter = EducationAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRw()
        viewModel.list.observe(viewLifecycleOwner) {
            educationAdapter.updateList(it)
        }

        educationAdapter.onDeleteItem { position ->
            viewModel.deleteItem(position)
            viewModel.updateList()
        }

        educationAdapter.onEditItem { position ->
            viewModel.modifyItem(position)
            EducationHelperDialog().show(childFragmentManager, "education")
        }


        binding.newEdu.setOnClickListener {
            viewModel.modifyItem(null)
            EducationHelperDialog().show(childFragmentManager, "education")
        }
        binding.next.setOnClickListener {
            val eduModel = PersAndWorkAndEduModel(model, viewModel.eduList.toList())
            val action =
                EducationFragmentDirections.actionEducationFragmentToAdditionalDataFragment(eduModel)
            findNavController().navigate(action)
        }

   }

    fun setRw() {
        with(binding.rwEdu) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = educationAdapter
        }

    }
}