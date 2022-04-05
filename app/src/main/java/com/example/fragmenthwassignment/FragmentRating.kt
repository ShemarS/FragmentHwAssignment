package com.example.fragmenthwassignment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_rating.*


class FragmentRating : Fragment() {

    lateinit var viewModel: FragmentViewModel
    val TAG = "MAN WHAT!"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        view.findViewById<Button>(R.id.buttonSaveRating).setOnClickListener {
            view.findViewById<Button>(R.id.buttonSaveRating).visibility = INVISIBLE
        }

        return view
    }

    fun saveRating(view: View) {
        val ratingbar = view.findViewById<RatingBar>(R.id.ratingBar)

        val myRatingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val rating = myRatingBar.rating.toString()

        Log.d(TAG, "This is currently rating: $rating");
    }









}