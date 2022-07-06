package com.ibrajix.mymusic.ui.screens.home.components

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.ui.theme.darkGrey
import com.ibrajix.mymusic.utils.Constants.GOOGLE_URL
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AlbumCard(
    modifier: Modifier = Modifier,
    album: Album,
    onClickCard : (String) -> Unit,
    onClickLike : (Boolean, Int) -> Unit
){

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .height(100.dp)
            .clickable {
                onClickCard(album.linkUrl ?: GOOGLE_URL)
            },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {

        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            GlideImage(
                imageModel = album.imageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(50.dp)
            )

            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {

                Text(
                    modifier = modifier
                        .padding(end = 20.dp),
                    text = album.albumName?:"",
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.onSecondary,
                )

                Text(
                    text = album.artistName?:"",
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.darkGrey,
                )

            }


            val imageLikedState = if (album.isLiked){
                R.drawable.ic_liked_state
            }
            else{
                R.drawable.ic_not_liked_state
            }

            AnimatedContent(targetState = album.isLiked) {
                Image(
                    modifier = modifier
                        .size(18.dp)
                        .clickable {
                            album.id?.let { onClickLike(album.isLiked, it) }
                        },
                    painter = painterResource(imageLikedState),
                    contentDescription = ""
                )
            }

        }

    }

}