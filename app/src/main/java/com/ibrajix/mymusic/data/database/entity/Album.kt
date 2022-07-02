package com.ibrajix.mymusic.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Making a different room entity because the model class needs converters for each of the variables...so yeah.!
 */

@Entity(tableName = "albums")
data class Album(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val albumName: String?,
    val artistName: String?,
    val imageUrl: String?,
    val linkUrl: String?,
    val isLiked: Boolean = false
)