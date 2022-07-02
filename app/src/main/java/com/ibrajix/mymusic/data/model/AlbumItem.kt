package com.ibrajix.mymusic.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class AlbumItem(
    val id: Id,
    @SerializedName("im:artist")
    val imArtist: ImArtist,
    @SerializedName("im:image")
    val imImage: ImImage,
    @SerializedName("im:name")
    val imName: ImName,
    val link: Link,
)