package com.example.myfood.services

import com.example.myfood.models.MealCategoriesResponse
import com.example.myfood.models.MealsByCategoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDBApiService {
    @GET("categories.php")
    suspend fun getMealCategories(): Response<MealCategoriesResponse>

    @GET("list.php?c=list")
    suspend fun getMealsByCategory(@Query("c") category: String): Response<MealsByCategoryResponse>
}
