package com.ibrajix.mymusic.ui.screens.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
    modifier: Modifier,
    navigator: DestinationsNavigator
) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ){

        GlideImage(
            imageModel = R.drawable.kanye
        )

        Box(modifier = modifier
            .fillMaxWidth(0.8F)
            .height(350.dp)
            .padding(bottom = 50.dp)
            .clip(RoundedCornerShape(50.dp))
            .align(Alignment.BottomCenter)
            .background(MaterialTheme.colors.secondary)
        ) {

            Text(
                modifier = modifier
                    .padding(30.dp),
                text = stringResource(id = R.string.explore_salt_pay_world_of_music),
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
                    .fillMaxWidth()
                    .height(80.dp)
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