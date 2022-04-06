package com.example.fragmenthwassignment

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class FragmentList : Fragment() {

    var FILE_NAME = "AnimalRating"
    var TAG = "MAN WHAT"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)

        fun serveAnimal() {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentRating())
                    .addToBackStack(null)
                    .commit()
            }
            else {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.details_container, FragmentRating())
                    .addToBackStack(null)
                    .commit()
            }

        }

        val imageIdList = listOf(R.id.imageButtonDog, R.id.imageButtonCat, R.id.imageButtonBear, R.id.imageButtonRabbit)

        for (imageId in imageIdList) {
            view.findViewById<ImageButton>(imageId).setOnClickListener {
                if (imageId == 2131230944) {
                    viewModel.setAnimal("Dog")
                }
                else if(imageId == 2131230943) {
                    viewModel.setAnimal("Cat")
                }
                else if(imageId == 2131230942) {
                    viewModel.setAnimal("Bear")
                }
                else if(imageId == 2131230945) {
                    viewModel.setAnimal("Rabbit")
                }
                serveAnimal()
            }
        }

        val sharedPreferences = this.requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val dogRating = sharedPreferences.getFloat("dog rating", 0.0F)
        val bearRating = sharedPreferences.getFloat("bear rating", 0.0F)
        val catRating = sharedPreferences.getFloat("cat rating", 0.0F)
        val rabbitRating = sharedPreferences.getFloat("rabbit rating", 0.0F)


        view.findViewById<TextView>(R.id.textViewDogRating).text = "Your rating: ${dogRating}"
        view.findViewById<TextView>(R.id.textViewBearRating).text = "Your rating: ${bearRating}"
        view.findViewById<TextView>(R.id.textViewCatRating).text = "Your rating: ${catRating}"
        view.findViewById<TextView>(R.id.textViewRabbitRating).text = "Your rating: ${rabbitRating}"
        return view
    }



}