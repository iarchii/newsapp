package xyz.thecodeside.news.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MediaEntity(
        val url: String,
        val format: String,
        val height: Int,
        val width: Int,
        val type: String,
        val subType: String?,
        val caption: String?,
        val copyright: String
) : Parcelable