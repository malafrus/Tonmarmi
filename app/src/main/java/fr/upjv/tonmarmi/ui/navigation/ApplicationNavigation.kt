package fr.upjv.tonmarmi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.upjv.tonmarmi.ui.screen.ApiScreen
import fr.upjv.tonmarmi.ui.screen.AuthScreen
import fr.upjv.tonmarmi.ui.screen.HomeScreen
import fr.upjv.tonmarmi.ui.screen.RecipePage


object NavigationPath {
    const val HOME_SCREEN = "home_screen"
    const val API_SCREEN = "api_screen"
    const val AUTH_SCREEN = "auth_screen"
    const val RECIPE_SCREEN = "recipe_screen/"
}


fun NavGraphBuilder.addHomeScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit
) {
    composable(
        route = NavigationPath.HOME_SCREEN,
    ) {
        HomeScreen(
            onButtonClick = {
                onButtonClick()
            },
            onButton2Click = {
                onButton2Click()
            }
        )
    }
}


fun NavGraphBuilder.addApiScreenNavigation(
    onItemListClick: (recipeIp: Int) -> Unit
) {
    composable(
        route = NavigationPath.API_SCREEN

    ) {
        ApiScreen(
            onItemListClick = {
                onItemListClick(it)
            }
        )
    }
}

fun NavGraphBuilder.addAuthScreenNavigation() {
    composable(
        route = NavigationPath.AUTH_SCREEN,
    ) {
        AuthScreen()
    }
}

fun NavGraphBuilder.addRecipeScreenNavigation(){
    composable(
        route = NavigationPath.RECIPE_SCREEN.plus("{recipeId}"),
        arguments = listOf(
            navArgument("recipeId"){
                type = NavType.IntType
            }
        )
    ){backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val recipeId = arguments.getInt("recipeId") ?: error("Missing Recipe ID argument")

        RecipePage(recipeId)
    }
}


@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.HOME_SCREEN,
    ) {
        addHomeScreenNav(
            onButtonClick = {
                navController.navigate(NavigationPath.API_SCREEN)
            },
            onButton2Click = {
                navController.navigate(NavigationPath.AUTH_SCREEN)
            }
        )
        addApiScreenNavigation(
            onItemListClick = {
                navController.navigate(NavigationPath.RECIPE_SCREEN.plus(it))
            }
        )
        addAuthScreenNavigation()
        addRecipeScreenNavigation()
    }
}
