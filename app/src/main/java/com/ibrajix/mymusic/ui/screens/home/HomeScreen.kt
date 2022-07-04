package com.ibrajix.mymusic.ui.screens.home

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.mymusic.data.database.viewmodel.AlbumDatabaseViewModel
import com.ibrajix.mymusic.ui.animations.StartScreenTransitionAnimation
import com.ibrajix.mymusic.ui.screens.home.components.HomeScreenItems
import com.ibrajix.mymusic.ui.theme.bgHome
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(style = StartScreenTransitionAnimation::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    albumDatabaseViewModel: AlbumDatabaseViewModel = hiltViewModel()
){

    val systemUiController = rememberSystemUiController()

    //get all albums
    albumDatabaseViewModel.doGetAllAlbums()
    val albums = albumDatabaseViewModel.getAllAlbums.collectAsState()


    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.bgHome
    )

    HomeScreenItems(navigator = navigator, albums = albums.value)

}