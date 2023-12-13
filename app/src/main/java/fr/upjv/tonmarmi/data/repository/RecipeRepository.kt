package fr.upjv.tonmarmi.data.repository

import fr.upjv.tonmarmi.architecture.CustomApplication
import fr.upjv.tonmarmi.architecture.RetrofitBuilder
import fr.upjv.tonmarmi.data.model.RecipeObject
import fr.upjv.tonmarmi.data.model.toDomain
import fr.upjv.tonmarmi.data.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepository {

    private val recipeDao = CustomApplication.instance.mApplicationDatabase.RecipeDao()


    suspend fun fetchRandomData(){
        RetrofitBuilder.getRecipe().getRandomRecipe().meal.forEach{
            recipeDao.insert(it.toRoom())
        }
    }

    fun deleteAll(){
        recipeDao.deleteAll()
    }

    fun selectAll(): Flow<List<RecipeObject>>{
        return recipeDao.selectAll().map { list -> list.toDomain() }
    }

    fun selectRecipe(recipeId: Int): Flow<List<RecipeObject>>{
        return recipeDao.selectRecipeById(recipeId).map { item -> item.toDomain() }
    }
}