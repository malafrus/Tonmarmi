package fr.upjv.tonmarmi.data.remote

import fr.upjv.tonmarmi.data.model.Meal
import retrofit2.http.GET

interface RecipeEndpoint{
    @GET("random.php")
    suspend fun getRandomRecipe(): Meal
}