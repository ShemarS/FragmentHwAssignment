package com.example.fragmenthwassignment

import android.content.Context
import android.content.Context.MODE_PRIVATE
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
    private val FILE_NAME = "AnimalRating"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)


        fun saveData(){
            val sharedPreferences = this.requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putFloat("dog rating", viewModel.getDogRate())
            editor.putFloat("bear rating", viewModel.getBearRate())
            editor.putFloat("cat rating", viewModel.getCatRate())
            editor.putFloat("rabbit rating", viewModel.getRabbitRate())
            editor.apply()
        }

        view.findViewById<Button>(R.id.buttonSaveRating).setOnClickListener {
            val ratingBar = view?.findViewById<RatingBar>(R.id.ratingBar)
            val rating = ratingBar?.rating
            if (rating != null) {
                viewModel.setRating(rating)
            }
            saveData()
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentList())
                    .addToBackStack(null)
                    .commit()
            }
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentList())
                    .addToBackStack(null)
                    .commit()
            }
        }

        val sharedPreferences = this.requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val dogRating = sharedPreferences.getFloat("dog rating", 0.0F)
        val bearRating = sharedPreferences.getFloat("bear rating", 0.0F)
        val catRating = sharedPreferences.getFloat("cat rating", 0.0F)
        val rabbitRating = sharedPreferences.getFloat("rabbit rating", 0.0F)

        when {
            viewModel.getAnimal() == "Dog" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.dog)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
                view.findViewById<RatingBar>(R.id.ratingBar).progress = (dogRating * 2).toInt()
            }
            viewModel.getAnimal() == "Bear" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.bear)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
                view.findViewById<RatingBar>(R.id.ratingBar).progress = (bearRating *2).toInt()
            }
            viewModel.getAnimal() == "Cat" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.cat)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
                view.findViewById<RatingBar>(R.id.ratingBar).progress = (catRating *2).toInt()
            }
            viewModel.getAnimal() == "Rabbit" -> {
                view.findViewById<ImageView>(R.id.imageViewSelectedAnimal).setImageResource(R.drawable.rabbit)
                view.findViewById<TextView>(R.id.textViewSelectedAnimal).text = viewModel.getAnimal()
                view.findViewById<RatingBar>(R.id.ratingBar).progress = (rabbitRating *2).toInt()
            }
        }
        return view
    }
}