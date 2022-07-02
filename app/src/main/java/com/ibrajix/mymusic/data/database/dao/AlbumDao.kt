package com.ibrajix.mymusic.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrajix.mymusic.data.database.entity.Album
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlbum(albums: List<Album>)

    @Query("SELECT * FROM albums")
    fun getAlbums(): Flow<List<Album>>

    @Query("UPDATE albums SET isLiked = :isLiked WHERE id = :id")
    fun updateAlbumLikedState(isLiked: Boolean, id: Int?)

    @Query("SELECT * FROM albums WHERE isLiked = :isLiked")
    fun getAllFavoriteAlbums(isLiked: Boolean = true) : Flow<List<Album>>

    @Query("SELECT EXISTS (SELECT 1 FROM albums WHERE id = :id)")
    fun checkIAlbumIsLiked(id: Int): Flow<Boolean>

}