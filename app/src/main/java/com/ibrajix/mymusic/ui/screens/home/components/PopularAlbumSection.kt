package com.ibrajix.mymusic.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PopularAlbumSection(
    modifier: Modifier = Modifier,
    cardTextTitle: Int,
    cardTextItem: Int,
    cardImage: Int,
    onPopularAlbumCardClicked: () -> Unit
){

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        style = MaterialTheme.typography.h2,
        fontSize = 20.sp,
        color = MaterialTheme.colors.onSecondary,
        text = stringResource(id = cardTextTitle)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp)
            .height(150.dp)
            .clickable {
                onPopularAlbumCardClicked()
            },
        shape = RoundedCornerShape(30.dp),
        backgroundColor = MaterialTheme.colors.primary
    ){

        Row(modifier = modifier
            .fillMaxSize()
            .padding(start = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = modifier
                    .fillMaxWidth(0.6f),
                text = stringResource(cardTextItem),
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.secondary,
            )

            GlideImage(
                modifier = modifier
                    .size(100.dp),
                imageModel = cardImage
            )
        }

    }

}