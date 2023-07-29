package com.example.myfood.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfood.models.MealCategory
import com.example.myfood.services.MealDBApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealDBApiService::class.java)

    private val _mealCategories = MutableLiveData<List<MealCategory>>()
    val mealCategories: LiveData<List<MealCategory>> get() = _mealCategories

    init {
        fetchMealCategories()
    }

    private fun fetchMealCategories() {
        viewModelScope.launch {
            try {
                val response = apiService.getMealCategories()
                if (response.isSuccessful) {
                    _mealCategories.value = response.body()?.categories
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}


