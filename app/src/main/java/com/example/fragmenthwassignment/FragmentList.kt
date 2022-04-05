package com.example.fragmenthwassignment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class FragmentList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)

        fun serveAnimal() {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                // We are in portrait orientation
                // Load Detail fragment, i.e., replace listview fragment with detail fragment
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentRating())
                    .addToBackStack(null)
                    .commit()
            }
            else {
                // We are in landscape orientation
                // Load Detail fragment, i.e., replace the current detail fragment
                // with detail fragment containing the selected item's details
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.details_container, FragmentRating())
                    .addToBackStack(null)
                    .commit()
            }

        }


        view.findViewById<ImageButton>(R.id.imageButtonDog).setOnClickListener {
            viewModel.setAnimal("Dog")
            serveAnimal()
        }

        view.findViewById<ImageButton>(R.id.imageButtonBear).setOnClickListener {
            viewModel.setAnimal("Bear")
            serveAnimal()
        }

        view.findViewById<ImageButton>(R.id.imageButtonCat).setOnClickListener {
            viewModel.setAnimal("Cat")
            serveAnimal()
        }

        view.findViewById<ImageButton>(R.id.imageButtonRabbit).setOnClickListener {
            viewModel.setAnimal("Rabbit")
            serveAnimal()
        }

        view.findViewById<TextView>(R.id.textViewDogRating).text = "Your rating: ${viewModel.getDogRate()}"
        view.findViewById<TextView>(R.id.textViewBearRating).text = "Your rating: ${viewModel.getBearRate()}"
        view.findViewById<TextView>(R.id.textViewCatRating).text = "Your rating: ${viewModel.getCatRate()}"
        view.findViewById<TextView>(R.id.textViewRabbitRating).text = "Your rating: ${viewModel.getRabbitRate()}"

        return view
    }




}