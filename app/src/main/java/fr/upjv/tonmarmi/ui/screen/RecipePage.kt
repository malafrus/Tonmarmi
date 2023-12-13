package fr.upjv.tonmarmi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.tonmarmi.ui.model.RecipeItemUi
import fr.upjv.tonmarmi.ui.viewmodel.RecipeViewModel

@Composable
fun RecipePage(recipeId: Int){
    val viewModel: RecipeViewModel = viewModel()
    val recipes = viewModel.init(recipeId).collectAsState(emptyList()).value
    
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        items(recipes.size) {
            recipes[it].name?.let { it1 -> Text(text = it1) }
            val painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = recipes[it].image)
                    .build()
            )
            Image(
                modifier = Modifier.size(128.dp),
                painter = painter,
                contentDescription = null,
            )

        }
    }

    
    
}