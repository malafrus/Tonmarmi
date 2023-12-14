package fr.upjv.tonmarmi.ui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.tonmarmi.ui.theme.TonmarmiTheme
import fr.upjv.tonmarmi.R
import fr.upjv.tonmarmi.ui.viewmodel.RecipesViewModel


// API : TheMealDB : https://www.themealdb.com/api.php
// API Racine request : www.themealdb.com/api/json/v1/ + tocken = 1
// -> www.themealdb.com/api/json/v1/1/

@Composable
fun ApiScreen(
    onItemListClick: (recipeId: Int) -> Unit,
)
{
    val context = LocalContext.current
    val viewModel: RecipesViewModel = viewModel()
    val recipes = viewModel.recipes.collectAsState(emptyList()).value

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        item{
            Text(text = stringResource(id = R.string.API))
        }
        item {
            Box(modifier = Modifier.fillMaxWidth()){
                LazyColumn (
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(height = 500.dp, width = 0.dp),
                    contentPadding = PaddingValues(10.dp)
                ){
                    items(recipes.size){ recipeContent ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {

                                    Toast.makeText(context, "${recipes[recipeContent].id}", Toast.LENGTH_SHORT).show()
                                    onItemListClick(recipes[recipeContent].id)
                                }
                        ){
                            Spacer(
                                modifier = Modifier
                                    .height(1.dp)
                                    .background(Color.White)
                                    .fillMaxSize()
                            )
                            Column {
                                Text(text = "${recipes[recipeContent].id} - ${recipes[recipeContent].name}")
                                Spacer(
                                    modifier = Modifier
                                        .height(1.dp)
                                        .background(Color.White)
                                        .fillMaxSize()
                                )

                            }
                        }

                    }
                }
            }
        }
        item {
            Row {
                Button(
                    content = { Text(text = "Add") },
                    onClick = {
                        viewModel.insertRandomRecipe()
                    })
                Button(
                    content = { Text(text = "Delete")},
                    onClick = {
                        viewModel.deleteAllRecipe()
                    })
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    TonmarmiTheme{
        ApiScreen({})
    }
}