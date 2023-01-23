package lk.ac.kln.learn.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.md_theme_light_onSurfaceVariant
import com.example.compose.md_theme_light_onTertiaryContainer
import com.example.compose.md_theme_light_surfaceVariant
import com.example.compose.md_theme_light_tertiaryContainer
import lk.ac.kln.learn.CardDetail
import lk.ac.kln.learn.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LystCard(cardDetail: CardDetail) {

    var progress by remember {
        mutableStateOf(cardDetail.progress)
    }

    var expandedState by remember {
        mutableStateOf(false)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        colors = CardDefaults.elevatedCardColors(
            contentColor = md_theme_light_onSurfaceVariant,
            containerColor = md_theme_light_surfaceVariant,
        ),
        shape = Shapes.large,
        onClick = { expandedState = !expandedState }
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Text(
                "${cardDetail.title}",
                style = androidx.compose.material.MaterialTheme.typography.button.copy(fontSize = 20.sp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (expandedState) {

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {

                    AnimatedVisibility(visible = progress < 1f) {
                        Button(
                            onClick = {
                                if (progress < 1f) progress += 0.1f
                            },
                            contentPadding = PaddingValues(horizontal = 35.dp, vertical = 20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                "Open",
                                style = androidx.compose.material.MaterialTheme.typography.button
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                LinearProgressIndicator(
                    modifier = Modifier
                        .semantics(mergeDescendants = true) {}
                        .fillMaxWidth(),
                    progress = animatedProgress,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    trackColor = MaterialTheme.colorScheme.primary,
                )
            }

        }
    }
}