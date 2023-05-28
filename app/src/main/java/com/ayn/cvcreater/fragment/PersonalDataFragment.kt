package com.ayn.cvcreater.fragment

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ayn.cvcreater.databinding.FragmentPersonalDataBinding
import com.ayn.cvcreater.model.ModelPersonal
import com.ayn.cvcreater.room.PdfEntity
import com.ayn.cvcreater.room.generateDb
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*

class PersonalDataFragment : Fragment() {
    private lateinit var binding: FragmentPersonalDataBinding
    private var imageUrl: String? = null
    private val options = arrayOf("Single", "Married", "None")
    private var modelPersonalList = arrayListOf<EditText>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val pdfDatabase = PdfDatabase.getDatabase(requireContext())
        val pdfDatabase = generateDb(requireContext())
        lifecycleScope.launch {
            pdfDatabase?.additionalDao()?.insertUser(PdfEntity(1, "txt"))
        }

        with(binding) {
            modelPersonalList.add(name)
            modelPersonalList.add(surname)
            modelPersonalList.add(dob)
            modelPersonalList.add(adres)
            modelPersonalList.add(mobil)
            modelPersonalList.add(status)
            modelPersonalList.add(about)
            modelPersonalList.add(jobTitleName)
            modelPersonalList.add(mail)
        }

        binding.dob.setOnClickListener {
            LocalDate.now().plusYears(15).year

            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePicker = DatePickerDialog(
                requireContext(), { datePicker, year, month, day ->
                    binding.dob.setText("$day/${month + 1}/$year")
                }, year, month, day
            )
            datePicker.setTitle("Select date of birth")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Save", datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", datePicker)
            datePicker.show()
        }

        binding.photo.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.next.setOnClickListener {

            /*val name1 =""
             val surname1 =""
             val dob1 =""
             val address1 =""
             val contactNumber1 =""
             val socialStatus1 =""
             val description1 =""
             val email1 =""
             val modelPersonal = ModelPersonal(
                 name = name1,
                 surname = surname1,
                 dob = dob1,
                 address = address1,
                 phone = contactNumber1,
                 photo = imageUrl,
                 socialStatus = socialStatus1,
                 description = description1,
                 email = email1,
             )

             val action =
                 OpeningFragmentDirections.actionOpeningFragmentToWorkExperienceFragment(
                     modelPersonal
                 )
             findNavController().navigate(action) */

            if (modelPersonalList.any { it.text.isEmpty() }) {
                Toast.makeText(requireContext(), "Punktlar boş ola bilməz", Toast.LENGTH_LONG)
                    .show()
            } else
                with(binding) {
                    val name = name.text.toString()
                    val surname = surname.text.toString()
                    val dob = dob.text.toString()
                    val address = adres.text.toString()
                    val contactNumber = mobil.text.toString()
                    val socialStatus = status.text.toString()
                    val description = about.text.toString()
                    val email = mail.text.toString()
                    val jobTitle = jobTitleName.text.toString()
                    val modelPersonal = ModelPersonal(
                        name = name,
                        surname = surname,
                        dob = dob,
                        address = address,
                        phone = contactNumber,
                        photo = imageUrl,
                        socialStatus = socialStatus,
                        description = description,
                        email = email,
                        jobTitleName = jobTitle
                    )
                    val action =
                        OpeningFragmentDirections.actionOpeningFragmentToWorkExperienceFragment(
                            modelPersonal
                        )
                    findNavController().navigate(action)

                }
        }

        binding.status.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setItems(options) { _, which: Int ->
                    binding.status.setText(options[which])
                }.show()
        }
    }

    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            imageUrl = uri?.path.toString()
            Picasso.get().load(uri).into(binding.photo)
        }
}
