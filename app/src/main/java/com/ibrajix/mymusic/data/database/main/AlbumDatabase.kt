package com.ibrajix.mymusic.data.database.main

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrajix.mymusic.data.database.dao.AlbumDao
import com.ibrajix.mymusic.data.database.entity.Album

@Database(entities = [Album::class], version = 1)
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun AlbumDao() : AlbumDao



    private suspend fun prePopulateRoomWithLocalJson(){


    }

}