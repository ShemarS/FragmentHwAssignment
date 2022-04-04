package com.example.fragmenthwassignment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar


class FragmentRating : Fragment() {

    lateinit var viewModel: FragmentViewModel
    val TAG = "SUSSY"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment





        return inflater.inflate(R.layout.fragment_rating, container, false)

    }




    fun saveRating(view: View) {
        val myRatingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val rating = myRatingBar.rating.toString()

        Log.d(TAG, "This is currently rating: $rating");
    }




}