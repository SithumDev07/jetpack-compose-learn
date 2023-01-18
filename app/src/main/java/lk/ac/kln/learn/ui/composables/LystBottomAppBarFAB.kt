package lk.ac.kln.learn.ui.composables

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BottomAppBarFAB() {
    BottomAppBar(
        actions = {
            val actions = listOf(Icons.Filled.Check, Icons.Outlined.Delete, Icons.Outlined.Menu)
            for(action in actions) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(action, contentDescription = null)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.elevation(0.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    )
}