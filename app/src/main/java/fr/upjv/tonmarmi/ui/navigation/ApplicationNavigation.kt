package fr.upjv.tonmarmi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.tonmarmi.ui.screen.ApiScreen
import fr.upjv.tonmarmi.ui.screen.AuthScreen
import fr.upjv.tonmarmi.ui.screen.HomeScreen



object NavigationPath {
    const val HOME_SCREEN = "home_screen"
    const val API_SCREEN = "api_screen"
    const val AUTH_SCREEN = "auth_screen"
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


fun NavGraphBuilder.addApiScreenNavigation() {
    composable(
        route = NavigationPath.API_SCREEN,
    ) {
        ApiScreen()
    }
}

fun NavGraphBuilder.addAuthScreenNavigation() {
    composable(
        route = NavigationPath.AUTH_SCREEN,
    ) {
        AuthScreen()
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
            onButton2Click = {navController.navigate(NavigationPath.AUTH_SCREEN)}
        )
        addApiScreenNavigation()
        addAuthScreenNavigation()
    }
}
