package fr.upjv.tonmarmi.architecture

import com.google.gson.GsonBuilder
import fr.upjv.tonmarmi.data.remote.RecipeEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getRecipe(): RecipeEndpoint = retrofit.create(RecipeEndpoint::class.java)
}