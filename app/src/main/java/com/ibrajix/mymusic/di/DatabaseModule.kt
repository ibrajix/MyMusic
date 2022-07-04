package com.ibrajix.mymusic.di

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibrajix.mymusic.data.database.main.AlbumDatabase
import com.ibrajix.mymusic.utils.DefaultDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @ApplicationScope
    @Provides
    fun providesCoroutineScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)

    @Singleton
    @Provides
    fun providesRoomDatabase(
        @ApplicationContext context: Context,
        callback: AlbumDatabase.AlbumCallback
    ) = Room.databaseBuilder(
        context,
        AlbumDatabase::class.java,
        "album_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()



    @Provides
    fun providesAlbumDao(albumDatabase: AlbumDatabase) = albumDatabase.albumDao()

    @Singleton
    @Provides
    fun provideResourcesProvider(@ApplicationContext context: Context): Resources = context.resources

}