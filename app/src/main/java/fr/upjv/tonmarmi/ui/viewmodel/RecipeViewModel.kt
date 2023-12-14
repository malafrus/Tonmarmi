package fr.upjv.tonmarmi.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.tonmarmi.data.model.RecipeObject
import fr.upjv.tonmarmi.data.repository.RecipeRepository
import fr.upjv.tonmarmi.ui.model.RecipeItemUi
import fr.upjv.tonmarmi.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {

    private val recipeRepository: RecipeRepository by lazy { RecipeRepository() }
    private val _recipe = MutableStateFlow<List<RecipeItemUi>>(emptyList())
    val recipe get() = _recipe

    fun init(recipeId: Int): Flow<List<RecipeItemUi>>{
            return recipeRepository.selectRecipe(recipeId).map {
                list -> list.toUi()
            }
    }


    fun fetchRecipe(id : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            recipeRepository.selectRecipe(id).map {
                _recipe.emit(it.toUi())
            }
        }
    }


}