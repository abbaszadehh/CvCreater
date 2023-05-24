package com.ayn.cvcreater.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ayn.cvcreater.databinding.FragmentAddingDataBinding
import com.ayn.cvcreater.model.AdditionalDataModel
import com.ayn.cvcreater.model.PersAndWorkAndEduModel
import com.ayn.cvcreater.room.PdfDatabase
import com.ayn.cvcreater.room.PdfEntity
import com.google.gson.Gson

class AdditionalDataFragment : Fragment() {

    private lateinit var binding: FragmentAddingDataBinding
    private val args: AdditionalDataFragmentArgs by navArgs()
    private val preVmodel: PersAndWorkAndEduModel by lazy { args.PersWorkEduModel }
    private val pdfDatabase: PdfDatabase? by lazy { PdfDatabase.getDatabase(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddingDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.next.setOnClickListener {
            val model = AdditionalDataModel(1,preVmodel, binding.addData.text.toString())
            val pdf  = Gson().toJson(model,AdditionalDataModel::class.java)
            pdfDatabase?.additionalDao()?.insert(PdfEntity(1, pdf))
            val action =
                AdditionalDataFragmentDirections.actionAdditionalDataFragmentToTemplateFragment(
                    model
                )
            findNavController().navigate(action)
        }
    }


}