package project.rickandmortyapp2.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

sealed class Screen(val route: String) {
    object CharacterListScreen : Screen("characterListScreen")
    object CharacterDetailScreen : Screen("characterListScreen?id={id}")

    fun passId(id: Int): String {
        return "characterListScreen?id=$id"
    }
}

class RickAndMortyNavigation(navController: NavController) {

    val navigateToCharacterListScreen: () -> Unit = {
        navController.navigate(Screen.CharacterListScreen.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToCharacterDetailScreen = { id: Int ->
        navController.navigate(Screen.CharacterDetailScreen.passId(id)) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }

}