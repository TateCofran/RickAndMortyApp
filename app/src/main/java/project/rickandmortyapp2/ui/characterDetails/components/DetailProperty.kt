package project.rickandmortyapp2.ui.characterDetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import project.rickandmortyapp2.ui.theme.backgroundColor

@Composable
fun DetailProperty(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background)

    ) {
        Column {
            Text(text = label, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = value ?: "", color = Color.White, style = MaterialTheme.typography.displayMedium)
        }
    }
}