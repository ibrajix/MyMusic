package com.ibrajix.mymusic.ui.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.ui.screens.home.components.AlbumCard
import com.ibrajix.mymusic.ui.screens.home.components.SearchSection
import com.ibrajix.mymusic.ui.screens.search.viewmodel.SearchViewModel
import com.ibrajix.mymusic.ui.theme.bgHome
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    searchViewModel: SearchViewModel = hiltViewModel(),

){

    val searchTextState by searchViewModel.searchFieldTextState
    val searchedAlbums  = searchViewModel.matchedAlbums.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.bgHome)
            .padding(20.dp),
    ) {
        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable {
                            navigator.popBackStack()
                        },
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(id = R.string.icon_screen_reader)
                )

                SearchSection(
                    searchTextFieldValue = searchTextState,
                    onSearchTextFieldValueChange = { searchViewModel.updateSearchTextState(it) } ,
                    onSearchTextFieldClicked = {
                        //do search

                    },
                    searchFieldPlaceHolder = R.string.search_albums,
                    searchEnabled = true
                )
            }
        }

        if (searchedAlbums.value.isNotEmpty()){
            items(
                items = searchedAlbums.value
            ){ album->
                AlbumCard(album = album, onClick = {
                    //on click album
                })
            }
        }

        else
        {
            if (searchTextState.isNotEmpty()){
                item{
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            stringResource(id = R.string.no_result_found),
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

    }
}