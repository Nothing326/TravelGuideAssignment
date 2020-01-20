package com.example.travelguideassignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.travelguideassignment.fragments.BookMarkFragment
import com.example.travelguideassignment.fragments.NearbyFragment
import com.example.travelguideassignment.fragments.SearchFragment

class TabPagerAdapter2(fm : FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = NearbyFragment()
            1 -> fragment = NearbyFragment()
            2 -> fragment = NearbyFragment()
        }
        return fragment!!
    }
}