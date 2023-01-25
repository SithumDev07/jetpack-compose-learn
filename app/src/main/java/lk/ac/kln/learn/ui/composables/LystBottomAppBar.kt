package lk.ac.kln.learn.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.md_theme_light_onPrimaryContainer
import com.example.compose.md_theme_light_primaryContainer
import com.example.compose.md_theme_light_surface
import lk.ac.kln.learn.R
import lk.ac.kln.learn.model.Item
import lk.ac.kln.learn.viewmodel.ItemViewModelAbstract

@Composable
fun LystBottomAppBar(itemViewModel: ItemViewModelAbstract, handler: () -> Unit) {
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
                onClick = {
                    handler()
                    itemViewModel.addItem(Item(text = "Hello There"))
                },
                contentPadding = PaddingValues(horizontal = 35.dp, vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = md_theme_light_primaryContainer,
                    contentColor = md_theme_light_onPrimaryContainer
                )
            ) {
                Text(
                    text = stringResource(id = R.string.add_item),
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Icon(Icons.Filled.Add, contentDescription = "Search")
            }
        }
    }
}