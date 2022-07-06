package com.ibrajix.mymusic.ui.screens.home

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.mymusic.data.database.viewmodel.AlbumDatabaseViewModel
import com.ibrajix.mymusic.ui.animations.StartScreenTransitionAnimation
import com.ibrajix.mymusic.ui.screens.details.OpenAlbumDetails
import com.ibrajix.mymusic.ui.screens.home.components.HomeScreenItems
import com.ibrajix.mymusic.ui.theme.bgHome
import com.ibrajix.mymusic.utils.Constants.APPLE_MUSIC_WEBSITE
import com.ibrajix.mymusic.utils.Constants.GOOGLE_WEBSITE
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(style = StartScreenTransitionAnimation::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    albumDatabaseViewModel: AlbumDatabaseViewModel = hiltViewModel()
){

    val systemUiController = rememberSystemUiController()

    var shouldOpenAlbumDetails by remember { mutableStateOf(false) }
    var albumUrl by rememberSaveable { mutableStateOf(GOOGLE_WEBSITE)}

    if (shouldOpenAlbumDetails){
        OpenAlbumDetails(albumUrl = albumUrl)
        shouldOpenAlbumDetails = false
    }

   var shouldOpenTrendingAlbums by remember { mutableStateOf(false) }

    if (shouldOpenTrendingAlbums){
        OpenAlbumDetails(albumUrl = APPLE_MUSIC_WEBSITE)
        shouldOpenTrendingAlbums = false
    }

    //get all albums
    albumDatabaseViewModel.doGetAllAlbums()
    val albums = albumDatabaseViewModel.getAllAlbums.collectAsState()


    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.bgHome
    )

    HomeScreenItems(navigator = navigator, albums = albums.value,
        onCardClicked = {
        shouldOpenAlbumDetails = true
        albumUrl = it
    },
        onPopularAlbumClicked = {
           shouldOpenTrendingAlbums = true
        }
    )


}