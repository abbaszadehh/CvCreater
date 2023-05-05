package com.ayn.cvcreater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ayn.cvcreater.databinding.FragmentWorkExperienceBinding

class WorkExperienceFragment : Fragment() {

    private lateinit var binding: FragmentWorkExperienceBinding
    private val args: WorkExperienceFragmentArgs by navArgs()
    private val modelPersonal : ModelPersonal by lazy { args.modelPersonal }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkExperienceBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}