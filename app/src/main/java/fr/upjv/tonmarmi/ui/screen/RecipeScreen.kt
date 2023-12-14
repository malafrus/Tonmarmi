package fr.upjv.tonmarmi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.tonmarmi.ui.viewmodel.RecipeViewModel

@Composable
fun RecipePage(recipeId: Int){
    val uriHandler = LocalUriHandler.current
    val viewModel: RecipeViewModel = viewModel()
    //val recipes = viewModel.recipe.collectAsState().value
    //viewModel.fetchRecipe(recipeId)
    val recipes = viewModel.init(recipeId).collectAsState(emptyList()).value
    
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)

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
        items(recipes.size){
            val linkText = "Tuto Youtube"
            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, textDecoration = TextDecoration.Underline)){
                    append(linkText)
                    recipes[it].youtube?.let { it1 ->
                        addStringAnnotation(
                            tag= "URL",
                            annotation = it1,
                            start = 0,
                            end = linkText.length
                        )
                    }
                }
            }

            ClickableText(
                modifier = Modifier,
                text = annotatedText,
                onClick ={ offset ->
                    annotatedText.getStringAnnotations(
                        tag = "URL",
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let {
                        annotation ->
                        uriHandler.openUri(annotation.item)
                    }
                },
            )
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxSize()
            )
            Text(text = "Category :")
        }
        items(recipes.size){
            Text(text = recipes[it].category!![0])
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxSize()
            )
            Text(text = "Area :")
        }
        items(recipes.size){
            recipes[it].area?.let { it1 -> Text(text = it1) }
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxSize()
            )
            Text(text = "Tags :")
        }
        items(recipes.size){
            recipes[it].tags?.let { it1 -> Text(text = it1) }
        }

        item {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxSize()
            )
            Text(text = "Ingredients :")
        }
        items(recipes.size){
            if(recipes[it].ingredients.size == recipes[it].measures.size){
                for(i in 0 until recipes[it].ingredients.size-1) {
                    Text(text = "${recipes[it].ingredients[i]} : ${recipes[it].measures[i]}")
                }
            }
            else {
                for(i in 0 until recipes[it].ingredients.size-1) {
                    Text(text = "${recipes[it].ingredients[i]}")
                }
            }


        }

        item{
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxSize()
            )
            Text(text = "Instructions : ")
        }
        items(recipes.size){
            recipes[it].instructions?.let { it1 -> Text(text = it1) }
        }
        items(recipes.size){
            val linkText = "Source"
            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)){
                    append(linkText)
                    recipes[it].source?.let { it1 ->
                        addStringAnnotation(
                            tag= "URL",
                            annotation = it1,
                            start = 0,
                            end = linkText.length
                        )
                    }
                }
            }

            ClickableText(
                modifier = Modifier,
                text = annotatedText,
                onClick ={ offset ->
                    annotatedText.getStringAnnotations(
                        tag = "URL",
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let {
                            annotation ->
                        uriHandler.openUri(annotation.item)
                    }
                },
            )
        }
    }
}