package project.rickandmortyapp2.ui.characterList

import project.rickandmortyapp2.R
import project.rickandmortyapp2.domain.model.Characters
import project.rickandmortyapp2.ui.characterList.components.CharacterItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest



@Composable
fun CharactersScreen(
    onItemClick: (Int) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val snackbarHostState = remember { SnackbarHostState() } // Manage snackbar state

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when (event) {
                is CharactersViewModel.UIEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize() // Applied to ensure bottom bar positioning
    ) {
        // Material 3 top app bar
        CharactersTopBar()

        // Bottom navigation using Surface for consistency
        CharactersBottomBar(
            showPrevious = state.showPrevious,
            showNext = state.showNext,
            onPreviousPress = { viewModel.getCharacters(false) },
            onNextPress = { viewModel.getCharacters(true) }
        )
        // Main content within a Surface
        Surface(
            color = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.fillMaxSize()
        ) {
            CharactersContent(
                onItemClick = onItemClick,
                isLoading = state.isLoading,
                characters = state.characters
            )

            // Display Snackbar within the Surface
            SnackbarHost(hostState = snackbarHostState)

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.characters_title),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    .background(MaterialTheme.colorScheme.surface)
            )
        },
    )
}


@Composable
fun CharactersContent(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
    isLoading: Boolean = false,
    characters: List<Characters> = emptyList()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        LazyColumn(contentPadding = PaddingValues(vertical = 6.dp),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(characters.size) { index ->
                    CharacterItem(
                        modifier = Modifier.fillMaxWidth(),
                        item = characters[index],
                        onItemClick = { onItemClick(it) }
                    )
                }
            }
        )
        if (isLoading) FullScreenLoading()
    }
}

@Composable
fun CharactersBottomBar(
    showPrevious: Boolean,
    showNext: Boolean,
    onPreviousPress: () -> Unit,
    onNextPress: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = onPreviousPress,
                enabled = showPrevious,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.previous_button))
            }
            TextButton(
                onClick = onNextPress,
                enabled = showNext,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.next_button))
            }
        }
    }
}
@Composable
private fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}
