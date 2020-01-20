package com.example.travelguideassignment.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.travelguideassignment.R
import com.example.travelguideassignment.fragments.BookMarkFragment
import com.example.travelguideassignment.fragments.CalendarFragment
import com.example.travelguideassignment.fragments.HomeFragment
import com.example.travelguideassignment.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        //initial HomeFramgment
        openFragment(HomeFragment())

        bottomNavigation.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.bottom_nav_home -> {
                            openFragment(HomeFragment())
                            return true
                        }
                        R.id.bottom_nav_search -> {
                            openFragment(SearchFragment())
                            return true
                        }
                        R.id.bottom_nav_calendar -> {
                            openFragment(CalendarFragment())
                            return true
                        }
                        R.id.bottom_nav_bookmark -> {
                            openFragment(BookMarkFragment())
                            return true
                        }
                    }
                    return false
                }
            }
        )

    }

    fun openFragment(fm: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fm)
            .commit()
    }
}
