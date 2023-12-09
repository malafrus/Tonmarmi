package fr.upjv.tonmarmi.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import fr.upjv.tonmarmi.R
import fr.upjv.tonmarmi.ui.theme.TonmarmiTheme
import fr.upjv.tonmarmi.ui.navigation.HomeNavHost

// API : TheMealDB : https://www.themealdb.com/api.php
// API Racine request : www.themealdb.com/api/json/v1/ + tocken = 1
// -> www.themealdb.com/api/json/v1/1/


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TonmarmiTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier,
                    topBar ={
                        TopAppBar(
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                            title = { Text(
                                text = stringResource(id = R.string.app_name),
                            ) },
                            navigationIcon = {
                                IconButton(onClick = {
                                    //navController.popBackStack()
                                    if(!navController.popBackStack()){
                                        finish()
                                    }

                                }) {
                                    Icon(
                                        imageVector = Icons.Rounded.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            },
                        )

                    }
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        HomeNavHost(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
