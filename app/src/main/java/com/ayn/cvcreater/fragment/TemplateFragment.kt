package com.ayn.cvcreater.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ayn.cvcreater.databinding.FragmentTemplateBinding
import com.ayn.cvcreater.model.AdditionalDataModel
import com.ayn.cvcreater.model.ModelPersonal


class TemplateFragment : Fragment() {

    private lateinit var binding: FragmentTemplateBinding
    private val args: TemplateFragmentArgs by navArgs()
    private val additionalData : AdditionalDataModel by lazy { args.fullModel }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTemplateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}