package com.ibrajix.mymusic.data.database.repository

import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.data.database.main.AlbumDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumDatabaseRepo @Inject constructor(
    private val albumDatabase: AlbumDatabase
) {

    /**
     * This is only needed because we need to read/write to the database before onCreate is called in our database callback - to prepopulate room database
     */
    suspend fun startDb() = albumDatabase.beginTransaction()
    suspend fun endDb() = albumDatabase.endTransaction()

    /**
     * Queries
     */

    val getAllAlbums: Flow<List<Album>> get() = albumDatabase.albumDao().getAlbums()

    suspend fun updateAlbumLikedStatus(isLiked: Boolean, albumId: Int) =
        albumDatabase.albumDao().updateAlbumLikedState(isLiked, albumId)

    suspend fun checkIfAlbumIsLiked(albumId: Int) : Flow<Boolean> =
        albumDatabase.albumDao().checkIAlbumIsLiked(albumId)

    val getAllFavoriteAlbums : Flow<List<Album>> get() = albumDatabase.albumDao().getAllFavoriteAlbums()


}