package com.ibrajix.mymusic.ui.screens.home

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.mymusic.ui.animations.StartScreenTransitionAnimation
import com.ibrajix.mymusic.ui.theme.bgHome
import com.ramcosta.composedestinations.annotation.Destination

@Destination(style = StartScreenTransitionAnimation::class)
@Composable
fun HomeScreen(){

    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.bgHome
    )


}