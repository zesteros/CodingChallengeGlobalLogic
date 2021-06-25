package com.angelo.codingchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.angelo.codingchallenge.model.Country

class MainActivityViewModel : ViewModel() {

    fun getCountries() = liveData {
        /**
         * Country  {name = “USA” , description =“country in North America”}
        Country  {name = “Australia” , description =“country in Australia”}
        Country  {name = “Egypt” , description =“An Ancient country”}
        Country  {name = “India” , description =“A diverse country”}
         */
        val countries = mutableListOf<Country>(
            Country("USA", "country in North America"),
            Country("Australia", "country in Australia"),
            Country("Egypt", "An Ancient country"),
            Country("India", "A diverse country")

        )
        emit(countries)
    }
}