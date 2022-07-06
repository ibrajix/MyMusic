package com.ibrajix.mymusic.ui.screens.search.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.data.database.repository.AlbumDatabaseRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val albumDatabaseRepo: AlbumDatabaseRepo) : ViewModel() {

    //search field state
    private val _searchFieldTextState: MutableState<String> = mutableStateOf("")
    val searchFieldTextState: State<String> = _searchFieldTextState

    private val _getAllAlbums = MutableStateFlow<List<Album>>(emptyList())
    val getAllAlbums : StateFlow<List<Album>> =  _getAllAlbums

    //get albums that matches search query
    private var _matchedAlbums = MutableStateFlow<List<Album>>(emptyList())
    val matchedAlbums: StateFlow<List<Album>> = _matchedAlbums

    init {
        getAlbums()
    }

    private fun getAlbums(){
        viewModelScope.launch {
            albumDatabaseRepo.getAllAlbums
                .collect{
                  _getAllAlbums.value = it
                }
        }
    }

    fun updateSearchTextState(newValue: String){

        //update search field with the new text as the user types
        _searchFieldTextState.value = newValue

        //set matched albums to nothing, if the user input is empty
        if (newValue.isEmpty()){
            _matchedAlbums.value = arrayListOf()
            return
        }

        //albums from search
        val albumsFromSearch = _getAllAlbums.value.filter { album ->
           album.albumName?.contains(newValue, true) == true ||
                   album.artistName?.contains(newValue, true) == true
        }

        _matchedAlbums.value = albumsFromSearch

    }

}