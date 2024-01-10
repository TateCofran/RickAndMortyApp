package project.rickandmortyapp2.ui

import project.rickandmortyapp2.ui.characterDetails.CharacterDetailScreen
import project.rickandmortyapp2.ui.characterList.CharactersScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun RickAndMortyNavGraph(
    modifier: Modifier = Modifier,
    navigationToCharacterListScreen: () -> Unit,
    navigationToCharacterDetailScreen: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.CharacterListScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.CharacterListScreen.route) {
            CharactersScreen(onItemClick = { navigationToCharacterDetailScreen(it) })
        }
        composable(
            route = Screen.CharacterDetailScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            CharacterDetailScreen(
                upPress = navigationToCharacterListScreen
            )
        }

    }
}