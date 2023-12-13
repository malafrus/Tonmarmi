package fr.upjv.tonmarmi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.tonmarmi.data.repository.RecipeRepository
import fr.upjv.tonmarmi.ui.model.RecipeItemUi
import fr.upjv.tonmarmi.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RecipesViewModel: ViewModel() {

    private val recipeRepository: RecipeRepository by lazy { RecipeRepository() }
    private val recipes: Flow<List<RecipeItemUi>>
        get() = recipeRepository.selectAll().map {
            list -> list.toUi()
        }

    val recipe = recipes

    fun insertRandomRecipe(){
        viewModelScope.launch(Dispatchers.IO){
            recipeRepository.fetchRandomData()
        }
    }

    fun deleteAllRecipe(){
        viewModelScope.launch(Dispatchers.IO){
            recipeRepository.deleteAll()
        }
    }
}