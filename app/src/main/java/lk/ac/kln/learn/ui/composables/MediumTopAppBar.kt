package lk.ac.kln.learn.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.KeyboardVoice
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LystMediumTopAppBar(handler: () -> Unit, scrollBehavior: TopAppBarScrollBehavior) {
    MediumTopAppBar(
        title = {
            Text(
                "Lyst Shopping",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.button.copy(fontSize = 30.sp)
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Black,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { handler() }) {
                Icon(Icons.Filled.KeyboardVoice, contentDescription = null)
            }
            IconButton(onClick = { handler() }) {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior
    )
}