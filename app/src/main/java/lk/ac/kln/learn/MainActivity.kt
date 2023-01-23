package lk.ac.kln.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.*
import kotlinx.coroutines.launch
import lk.ac.kln.learn.ui.composables.LystBottomAppBar
import lk.ac.kln.learn.ui.composables.LystCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Remember()
                }
            }
        }
    }
}

data class CardDetail(
    val title: String,
    val description: String,
    val color: Color,
    val progress: Float
)


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Remember() {

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    Text(
                        "Lyst Shopping",
                        style = TextStyle(fontSize = 24.sp,),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                },
                actions = {
                    IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Searching") } }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Open Menu") } }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Open Menu")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = md_theme_light_surface,
                    titleContentColor = md_theme_light_onPrimaryContainer,
                    actionIconContentColor = md_theme_light_onPrimaryContainer,
                    navigationIconContentColor = md_theme_light_onPrimaryContainer
                )
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = { LystBottomAppBar(handler = { scope.launch { snackbarHostState.showSnackbar("Hey!!! Jetpack") } }) },
    ) { paddingValues ->

        val cards = mutableListOf(
            CardDetail(
                "Personal Health Care",
                "Personal Health Care",
                Color.White,
                progress = 0.4f
            ),
            CardDetail(
                "Diary Products",
                "Personal Health Care",
                Color.White,
                progress = 0.8f
            ),
            CardDetail(
                "Vegetables",
                "Personal Health Care",
                Color.White,
                progress = 0.12f
            ),
            CardDetail(
                "Fruits",
                "Personal Health Care",
                Color.White,
                progress = 1f
            ),
            CardDetail(
                "Electronic",
                "Personal Health Care",
                Color.White,
                progress = 0.4f
            ),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = md_theme_light_surface)
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = paddingValues.calculateTopPadding() + 15.dp
                )
                .padding(horizontal = 10.dp)
        ) {

            items(cards.size) {
                LystCard(cards[it])
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}



