package com.example.travelguideassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.travelguideassignment.R
import com.example.travelguideassignment.adapters.TabPagerAdapter2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the alayout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val locationSpinner = view.location_spinner
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity!!,
            R.array.locations,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            locationSpinner.adapter = adapter
        }


        val adapter = TabPagerAdapter2(activity!!.supportFragmentManager, lifecycle)
        val viewPager2 = view.viewPager2
        val tabLayout = view.tabLayout
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Nearby"
                1 -> tab.text = "Popular"
                2 -> tab.text = "All"

            }
        }.attach()




        return view

    }

}
