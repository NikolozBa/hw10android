package com.example.hw10android.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw10android.fragments.HomeFragment
import com.example.hw10android.fragments.SettingsFragment

class PagerAdapter(activity: AppCompatActivity) :FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> SettingsFragment()
            else-> HomeFragment()
        }
    }
}