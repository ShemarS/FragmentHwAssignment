package com.example.fragmenthwassignment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class FragmentViewModel: ViewModel() {

    var dRating = 0.0F

    var dogRating = ""
    var catRating = ""
    var bearRating = ""
    var rabbitRating = ""
    var selectedAnimal = ""

    fun setRatingTest(ratingPassed: Float?) {
        if (selectedAnimal == "Dog") {
            if (ratingPassed != null) {
                dRating = ratingPassed
            }
        }
    }

    fun setRating(ratingPassed: String) {
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

    fun getDogRate(): String {
        return dogRating
    }

    fun getDogRateTest(): Float {
        return dRating
    }

    fun getBearRate(): String {
        return bearRating
    }

    fun getCatRate(): String {
        return catRating
    }

    fun getRabbitRate(): String {
        return rabbitRating
    }

    fun setAnimal(animalPassed: String) {
        selectedAnimal = animalPassed
    }

    fun getAnimal(): String {
        return selectedAnimal
    }


}