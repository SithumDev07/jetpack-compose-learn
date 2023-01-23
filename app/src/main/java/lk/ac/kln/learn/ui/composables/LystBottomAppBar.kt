package lk.ac.kln.learn.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.md_theme_light_onPrimaryContainer
import com.example.compose.md_theme_light_primaryContainer
import com.example.compose.md_theme_light_surface

@Composable
fun LystBottomAppBar(handler: () -> Unit) {
    BottomAppBar(
        contentPadding = PaddingValues(horizontal = 20.dp),
        containerColor = md_theme_light_surface,
        contentColor = md_theme_light_onPrimaryContainer,
        tonalElevation = 10.dp
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Navigation Icons
            Row() {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.CalendarMonth, contentDescription = "Calendar")
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Category, contentDescription = "Search")
                }
            }

            Button(
                onClick = { handler() },
                contentPadding = PaddingValues(horizontal = 35.dp, vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = md_theme_light_primaryContainer,
                    contentColor = md_theme_light_onPrimaryContainer
                )
            ) {
                Text(text = "New Item", style = MaterialTheme.typography.button, modifier = Modifier.padding(end = 5.dp))
                Icon(Icons.Filled.Add, contentDescription = "Search")
            }
        }
    }
}