package com.ayn.cvcreater.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayn.cvcreater.adapter.ViewPagerAdapter
import com.ayn.cvcreater.databinding.FragmentOpeningBinding
import com.google.android.material.tabs.TabLayoutMediator

class OpeningFragment : Fragment() {

    private lateinit var binding : FragmentOpeningBinding
    private lateinit var  adapter : ViewPagerAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentOpeningBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ViewPagerAdapter(requireActivity())
        val list = arrayListOf(Home1Fragment(), Home2Fragment(), PersonalDataFragment())
        adapter.setList(list)
        binding.viewPg.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPg) { tab, position ->
        }.attach()

    }


    }