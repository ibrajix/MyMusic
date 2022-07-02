package com.ibrajix.mymusic.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibrajix.mymusic.data.database.dao.AlbumDao
import com.ibrajix.mymusic.data.database.main.AlbumDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    fun providesRoomDatabase(
        @ApplicationContext context: Context,
    )
    {

    }

}