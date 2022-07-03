package com.ibrajix.mymusic.data.database.main

import android.content.res.Resources
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.data.database.dao.AlbumDao
import com.ibrajix.mymusic.data.database.entity.Album
import com.ibrajix.mymusic.data.model.AlbumItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Database(entities = [Album::class], version = 1)
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun AlbumDao() : AlbumDao

    class AlbumCallback @Inject constructor(
        private val albumDatabase: Provider<AlbumDatabase>,
        @Singleton private val applicationScope: CoroutineScope,
        private val resources: Resources
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val albumDao = albumDatabase.get().AlbumDao()
            applicationScope.launch {
                prePopulateRoomWithLocalJson(albumDao)
            }
        }

        private suspend fun prePopulateRoomWithLocalJson(albumDao: AlbumDao){

            val jsonString = resources.openRawResource(R.raw.albums).bufferedReader().use {
                it.readText()
            }

            val typeToken = object : TypeToken<List<AlbumItem>>() {}.type
            val jsonAlbums = Gson().fromJson<List<AlbumItem>>(jsonString, typeToken)

            val roomAlbumList = mutableListOf<Album>()

            for (album in jsonAlbums){
                roomAlbumList.add(
                    Album(
                        albumName = album.imName.label,
                        artistName = album.imArtist.label,
                        imageUrl = album.imImage.label,
                        linkUrl = album.link.attributes.href
                    )
                )
            }

            albumDao.saveAlbum(roomAlbumList)
        }
    }

}