package lk.ac.kln.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import lk.ac.kln.learn.model.Item
import lk.ac.kln.learn.ui.composables.LystBottomAppBar
import lk.ac.kln.learn.ui.composables.LystCard
import lk.ac.kln.learn.viewmodel.ItemViewModel
import lk.ac.kln.learn.viewmodel.ItemViewModelAbstract

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Remember(itemViewModel)
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
@Composable
fun Remember(itemViewModel: ItemViewModelAbstract) {

    val itemListState = itemViewModel.itemListFlow.collectAsState(initial = listOf())

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
                        style = TextStyle(fontSize = 24.sp),
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
        bottomBar = {
            LystBottomAppBar(
                itemViewModel = itemViewModel,
                handler = { scope.launch { snackbarHostState.showSnackbar("Hey!!! Jetpack") } })
        },
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
//                .fillMaxSize()
//                .background(color = md_theme_light_surface)
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = paddingValues.calculateTopPadding() + 15.dp
                )
                .padding(horizontal = 10.dp)
        ) {

            items(itemListState.value.size) { index ->
                val item = itemListState.value[index]
                LystCard(text = item.text)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Preview
@Composable
fun RememberPreview() {
    Remember(itemViewModel = object : ItemViewModelAbstract {
        override val itemListFlow: Flow<List<Item>>
            get() = flowOf(
                listOf(
                    Item(text = "Item One"),
                    Item(text = "Item Two"),
                    Item(text = "Item Three"),
                    Item(text = "Item Four"),
                    Item(text = "Item Five"),
                    Item(text = "Item Six"),
                )
            )

        override fun addItem(item: Item) {}
    })
}



