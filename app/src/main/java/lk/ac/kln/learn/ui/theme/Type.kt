package lk.ac.kln.learn.ui.theme

import androidx.compose.material.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import lk.ac.kln.learn.R

val LexendDeca = FontFamily(
    Font(R.font.lexend_deca_regular),
    Font(R.font.lexend_deca_semibold, FontWeight.SemiBold),
    Font(R.font.lexend_deca_thin, FontWeight.Thin),
    Font(R.font.lexend_deca_bold, FontWeight.Bold),
    Font(R.font.lexend_deca_medium, FontWeight.Medium),
    Font(R.font.lexend_deca_extra_bold, FontWeight.ExtraBold),
    Font(R.font.lexend_deca_black, FontWeight.Black),
    Font(R.font.lexend_deca_extra_light, FontWeight.ExtraLight),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    overline = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)