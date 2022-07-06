package com.ibrajix.mymusic.ui.screens.home.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.ui.theme.bgHome
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.data.database.viewmodel.AlbumDatabaseViewModel
import com.ibrajix.mymusic.ui.screens.destinations.SearchScreenDestination
import com.ibrajix.mymusic.utils.Constants.APPLE_MUSIC_WEBSITE

@Composable
fun HomeScreenItems(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    albums: List<Album>,
    albumDatabaseViewModel: AlbumDatabaseViewModel = hiltViewModel(),
    onCardClicked: (String) -> Unit,
    onPopularAlbumClicked: () -> Unit
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.bgHome)
            .padding(20.dp)
    ){

        /**
         * Non-Dynamic Items
         */

        item {

            //first section
            UserHomeSection()

            //search home screen
            SearchSection(
                searchTextFieldValue = "",
                onSearchTextFieldValueChange = {  },
                onSearchTextFieldClicked = { navigator.navigate(SearchScreenDestination) },
                searchFieldPlaceHolder = R.string.search_albums,
                searchEnabled = false,
                showKeyboardOnStart = false
            )

            //popular item section
            PopularAlbumSection(
                cardTextTitle = R.string.popular,
                cardTextItem = R.string.top_trending_albums,
                cardImage = R.drawable.ic_character,
                onPopularAlbumCardClicked = {
                    //popular album clicked, go to apple music
                    onPopularAlbumClicked()
                }
            )

        }

        /**
         * Dynamic Items
         */

        item{

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                style = MaterialTheme.typography.h2,
                fontSize = 18.sp,
                color = MaterialTheme.colors.onSecondary,
                text = stringResource(id = R.string.all_albums)
            )

        }


        items(items = albums){ album->

            AlbumCard(
                album = album,
                onClickCard = { albumUrl->
                  //card clicked, go to details screen
                    onCardClicked(albumUrl)
                },
                onClickLike = { isLiked, albumId->
                    albumDatabaseViewModel.doUpdateAlbumLikedStatus(!isLiked, albumId)
                }
            )

        }

    }

}