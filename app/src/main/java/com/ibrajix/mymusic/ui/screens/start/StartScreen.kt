package com.ibrajix.mymusic.ui.screens.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.ui.animations.StartScreenTransitionAnimation
import com.ibrajix.mymusic.ui.screens.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.skydoves.landscapist.glide.GlideImage


@RootNavGraph(start = true)
@Destination(style = StartScreenTransitionAnimation::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ){

        GlideImage(
            imageModel = R.drawable.kanye
        )

        Card(modifier = modifier
            .fillMaxWidth(0.8F)
            .align(Alignment.BottomCenter)
            .padding(bottom = 50.dp),
            shape = RoundedCornerShape(50.dp),
            backgroundColor = MaterialTheme.colors.secondary
        ) {

            Column(
                modifier = modifier
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = modifier
                        .padding(30.dp),
                    text = stringResource(id = R.string.explore_your_world_of_music),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSecondary
                )

                Text(
                    modifier = modifier
                        .padding(horizontal = 30.dp),
                    text = stringResource(id = R.string.see_trending_songs_from_favs),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onSecondary
                )

                Button(
                    modifier = modifier
                        .fillMaxWidth(0.6f)
                        .height(80.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp),
                    shape = RoundedCornerShape(50.dp),
                    onClick = {
                        navigator.popBackStack()
                        navigator.navigate(HomeScreenDestination)
                    }
                ) {

                    Text(
                        text = stringResource(id =R.string.get_started),
                        style = MaterialTheme.typography.h3
                    )

                }
            }
        }
    }
}