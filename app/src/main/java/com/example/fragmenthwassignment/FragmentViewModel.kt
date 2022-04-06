package com.example.fragmenthwassignment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class FragmentViewModel: ViewModel() {

    var dogRating = 0.0F
    var catRating = 0.0F
    var bearRating = 0.0F
    var rabbitRating = 0.0F
    var selectedAnimal = ""



    fun setRating(ratingPassed: Float) {
        if (selectedAnimal == "Dog") {
            dogRating = ratingPassed
        }
        if (selectedAnimal == "Bear") {
            bearRating = ratingPassed
        }
        if (selectedAnimal == "Cat") {
            catRating = ratingPassed
        }
        if (selectedAnimal == "Rabbit") {
            rabbitRating = ratingPassed
        }
    }

    fun getDogRate(): Float {
        return dogRating
    }

    fun getBearRate(): Float {
        return bearRating
    }

    fun getCatRate(): Float {
        return catRating
    }

    fun getRabbitRate(): Float {
        return rabbitRating
    }

    fun setAnimal(animalPassed: String) {
        selectedAnimal = animalPassed
    }

    fun getAnimal(): String {
        return selectedAnimal
    }



}