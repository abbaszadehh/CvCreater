package com.ayn.cvcreater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayn.cvcreater.databinding.FragmentWorkExperienceBinding

class WorkExperienceFragment : Fragment() {

    private lateinit var binding: FragmentWorkExperienceBinding
    private val args: WorkExperienceFragmentArgs by navArgs()
    private val modelPersonal : ModelPersonal by lazy { args.modelPersonal }
    private val workAdapter = WorkExperienceAdapter()
    private val workList = arrayListOf<ModelWorkExperience>()

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
         workAdapter.updateList(workList)

         binding.newWork.setOnClickListener {
             val action = WorkExperienceFragmentDirections.actionWorkExperienceFragmentToEducationFragment()
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