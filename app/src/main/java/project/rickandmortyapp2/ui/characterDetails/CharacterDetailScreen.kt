package project.rickandmortyapp2.ui.characterDetails

import project.rickandmortyapp2.R
import project.rickandmortyapp2.ui.characterDetails.components.DetailProperty
import project.rickandmortyapp2.ui.characterDetails.components.mirroringBackIcon
import project.rickandmortyapp2.ui.characterDetails.components.CharacterImage
import project.rickandmortyapp2.domain.model.Character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    upPress: () -> Unit
) {
    val state = viewModel.state
    DetailContent(
        character = state.character,
        upPress = upPress
    )
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    character: Character?,
    upPress: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Column {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .height(240.dp),
                character = character,
            )
            Body(character = character)
        }
        Up(upPress)
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    character: Character?
) {
    Column(
        modifier = modifier
            .background(Color(0xFF1C9696)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterImage(image = character?.image)
        Text(
            text = character?.name ?: "",
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun Body(character: Character?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        DetailProperty(label = stringResource(id = R.string.specie), value = character?.species)
        DetailProperty(label = stringResource(id = R.string.status), value = character?.status)
        DetailProperty(label = stringResource(id = R.string.gender), value = character?.gender)
        DetailProperty(
            label = stringResource(id = R.string.first_seen_in),
            value = character?.origin?.name
        )
        DetailProperty(
            label = stringResource(id = R.string.last_known_location),
            value = character?.location?.name
        )
    }
}

@Composable
fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .size(36.dp)
    ) {
        Icon(
            imageVector = mirroringBackIcon(),
            tint = Color(0xffffffff),
            contentDescription = null
        )
    }
}