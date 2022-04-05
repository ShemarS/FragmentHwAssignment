package com.example.fragmenthwassignment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider


class FragmentRating : Fragment() {

    lateinit var viewModel: FragmentViewModel
    val TAG = "MAN WHAT!"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)


        view.findViewById<Button>(R.id.buttonSaveRating).setOnClickListener {
            val ratingBar = view?.findViewById<RatingBar>(R.id.ratingBar)
            val rating = ratingBar?.rating
            viewModel.setRatingTest(rating)

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                // We are in portrait orientation
                // Load Detail fragment, i.e., replace listview fragment with detail fragment
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentList())
                    .addToBackStack(null)
                    .commit()
            }
            else {
                // We are in landscape orientation
                // Load Detail fragment, i.e., replace the current detail fragment
                // with detail fragment containing the selected item's details
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentList())
                    .addToBackStack(null)
                    .commit()
            }

            //view.findViewById<Button>(R.id.buttonSaveRating).visibility = INVISIBLE

        }

        when {
            viewModel.getAnimal() == "Dog" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.dog)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()

            //Left off trying to get profress bar to align with rating
            //view.findViewById<RatingBar>(R.id.ratingBar).progress = viewModel.getDogRateTest().toInt()
            }
            viewModel.getAnimal() == "Bear" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.bear)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
            }
            viewModel.getAnimal() == "Cat" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.cat)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
            }
            viewModel.getAnimal() == "Rabbit" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.rabbit)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
            }
        }
        return view
    }
}