package com.ibrajix.mymusic.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R

//Custom font
val ManRope =  FontFamily(
    Font(R.font.manrope_extrabold, FontWeight.ExtraBold),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_semi_bold, FontWeight.SemiBold),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_regular, FontWeight.Normal),
    Font(R.font.manrope_light, FontWeight.Light),
)

// Set of Material typography styles to start with

val MyTypography = Typography(

    defaultFontFamily = ManRope,

    h1 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),

    h2 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    h3 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    body1 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    caption = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = ManRope,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),
)