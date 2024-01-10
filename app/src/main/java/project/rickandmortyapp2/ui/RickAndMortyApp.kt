package project.rickandmortyapp2.ui

import project.rickandmortyapp2.ui.theme.RickAndMortyApp2Theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController

@Composable
fun RickAndMortyApp() {
    RickAndMortyApp2Theme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            RickAndMortyNavigation(navController)
        }

        RickAndMortyNavGraph(
            navController = navController,
            navigationToCharacterListScreen =  navigationActions.navigateToCharacterListScreen,
            navigationToCharacterDetailScreen = navigationActions.navigateToCharacterDetailScreen
        )

    }
}