package com.ibrajix.mymusic.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ibrajix.mymusic.data.database.main.AlbumDatabase
import com.ibrajix.mymusic.data.database.viewmodel.AlbumDatabaseViewModel
import com.ibrajix.mymusic.ui.screens.NavGraphs
import com.ibrajix.mymusic.ui.theme.MyMusicTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val albumDatabaseViewModel: AlbumDatabaseViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        //open database
        albumDatabaseViewModel.openAndEndDatabase()

        setContent {
            MyMusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navHostEngine = rememberAnimatedNavHostEngine()
                    DestinationsNavHost(navGraph = NavGraphs.root, engine = navHostEngine)
                }
            }
        }
    }
}
