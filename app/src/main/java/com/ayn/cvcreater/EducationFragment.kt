package com.ayn.cvcreater

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayn.cvcreater.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    private lateinit var binding : FragmentEducationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentEducationBinding.inflate(inflater)
        return binding.root
    }

}