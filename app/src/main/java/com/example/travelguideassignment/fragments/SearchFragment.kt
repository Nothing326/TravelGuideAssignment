package com.example.travelguideassignment.fragments

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast

import com.example.travelguideassignment.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import java.text.SimpleDateFormat
import java.util.*

class SearchFragment : Fragment() {
    var cal  = Calendar.getInstance()
    var calForCheckOut = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        // create an OnDateSetListener
        val dateSetListenerForCheckOut = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                calForCheckOut.set(Calendar.YEAR, year)
                calForCheckOut.set(Calendar.MONTH, monthOfYear)
                calForCheckOut.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInViewForCheckOut()
            }
        }


        val edtCheckIn = view.edtCheckIn
        val edtCheckOut = view.edtCheckOut
        edtCheckOut.setOnClickListener{
            DatePickerDialog(activity!!,
                dateSetListenerForCheckOut,
                // set DatePickerDialog to point to today's date when it loads up
                calForCheckOut.get(Calendar.YEAR),
                calForCheckOut.get(Calendar.MONTH),
                calForCheckOut.get(Calendar.DAY_OF_MONTH)).show()
        }

        edtCheckIn.setOnClickListener{

            DatePickerDialog(activity!!,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()


}


        view.btnFilter.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(activity!!.supportFragmentManager,bottomSheetFragment.tag)

        }

        return view
    }
    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        val date = sdf.format(cal.getTime()).toString()
        edtCheckIn.setText(date)
    }
    private fun updateDateInViewForCheckOut(){
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        val date = sdf.format(calForCheckOut.getTime()).toString()
        edtCheckOut.setText(date)
    }

}
