package com.ibrajix.mymusic.data.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.data.database.repository.AlbumDatabaseRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumDatabaseViewModel @Inject constructor(private val albumDatabaseRepo: AlbumDatabaseRepo) : ViewModel() {

    /**
     * This is only needed because we need to read/write to the database before onCreate is called in our database callback - to prepopulate room database
     */
    fun openAndEndDatabase(){
        viewModelScope.launch(Dispatchers.IO) {
            albumDatabaseRepo.startDb()
            albumDatabaseRepo.endDb()
        }
    }

    private val _getAllAlbums = MutableStateFlow<List<Album>>(emptyList())
    val getAllAlbums : StateFlow<List<Album>> =  _getAllAlbums

    fun doGetAllAlbums(){
        viewModelScope.launch {
            albumDatabaseRepo.getAllAlbums
                .catch { e->
                    //get exception
                }
                .collect{
                    _getAllAlbums.value = it
                }
        }
    }

    private val _checkIfAlbumIsLiked = MutableStateFlow(false)
    val checkIfAlbumIsLiked : StateFlow<Boolean> =  _checkIfAlbumIsLiked

    fun doCheckIfAlbumIsLiked(albumId: Int){
        viewModelScope.launch {
            albumDatabaseRepo.checkIfAlbumIsLiked(albumId)
                .catch{ e->
                    //get exception
                }
                .collect{
                    _checkIfAlbumIsLiked.value = it
                }
        }
    }

    fun doUpdateAlbumLikedStatus(isLiked: Boolean, albumId: Int){
        viewModelScope.launch {
            albumDatabaseRepo.updateAlbumLikedStatus(isLiked, albumId)
        }
    }


    private val _getAllFavAlbums = MutableStateFlow<List<Album>>(emptyList())
    val getAllFavAlbums : StateFlow<List<Album>> =  _getAllFavAlbums

    fun doGetAllFavAlbums(){
        viewModelScope.launch {
            albumDatabaseRepo.getAllFavoriteAlbums
                .catch { e->
                    //get exception
                }
                .collect{
                    _getAllFavAlbums.value = it
                }
        }
    }

}