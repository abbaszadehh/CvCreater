package com.ayn.cvcreater.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayn.cvcreater.adapter.TempEduAdapter
import com.ayn.cvcreater.adapter.TemplateWorkAdapter
import com.ayn.cvcreater.databinding.FragmentTemplateBinding
import com.ayn.cvcreater.model.AdditionalDataModel
import com.ayn.cvcreater.utils.bitmapFromView
import com.ayn.cvcreater.utils.convertToPdf
import com.ayn.cvcreater.utils.saveBitmapToCache
import com.ayn.cvcreater.utils.shareImageUri
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class TemplateFragment : Fragment() {

    private lateinit var binding: FragmentTemplateBinding
    private val args: TemplateFragmentArgs by navArgs()
    private val additionalData: AdditionalDataModel by lazy { args.fullModel }
    private val workAdapter = TemplateWorkAdapter()
    private val eduAdapter = TempEduAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTemplateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personName.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.name
        binding.personSurname.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.surname
        binding.jobTitle.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.jobTitleName
        binding.mobil.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.phone
        binding.email.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.email
        binding.address.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.address
        val skills = additionalData.additionalText.replace(" ", "\n")
        binding.skillView.text = skills
        setPhoto()
        binding.aboutMe.text =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.description

        setWorkRecycler()
        val workItems = additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.workList
        workAdapter.updateList(workItems)

        setEduRecycler()
        val eduItems = additionalData.persAndWorkAndEduModel.eduList
        eduAdapter.updateList(eduItems)

        binding.convertPdf.setOnClickListener {
            val bitmap = bitmapFromView(binding.templatePdf)
            convertToPdf(requireContext(),bitmap)
            val uri = saveBitmapToCache(requireContext())
            shareImageUri(requireContext(),uri!!)
        }
    }

    private fun setPhoto() {
        val photo =
            additionalData.persAndWorkAndEduModel.workAndPersonalDataModel.modelPersonal.photo
        Picasso.get().load(photo).into(binding.photo)
    }

    fun setWorkRecycler() {
        with(binding.workRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = workAdapter
        }
    }

    fun setEduRecycler() {
        with(binding.eduRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = eduAdapter
        }
    }
}