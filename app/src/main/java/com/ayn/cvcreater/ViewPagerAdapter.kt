package com.ayn.cvcreater

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    private val list = ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list.get(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Fragment>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}