package com.example.fragmenthwassignment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class FragmentViewModel: ViewModel() {


    var ratings = ""

    fun setRating(positionPassed: String) {
        ratings = positionPassed
    }




}