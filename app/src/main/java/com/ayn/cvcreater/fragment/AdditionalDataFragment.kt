package com.ayn.cvcreater.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayn.cvcreater.databinding.FragmentAddingDataBinding

class AdditionalDataFragment : Fragment() {

    private lateinit var binding : FragmentAddingDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddingDataBinding.inflate(inflater)
        return binding.root
    }


}