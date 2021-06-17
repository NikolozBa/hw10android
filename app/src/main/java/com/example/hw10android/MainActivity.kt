package com.example.hw10android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.hw10android.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tab: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab = findViewById(R.id.tab)
        pager = findViewById(R.id.pager)
        adapter = PagerAdapter(this)

        pager.adapter = adapter

        TabLayoutMediator(tab, pager){tab, position ->
            when(position){
                0->tab.setIcon(R.drawable.home)
                1->tab.setIcon(R.drawable.settings)
            }
        }.attach()

    }
}