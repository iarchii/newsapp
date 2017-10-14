package xyz.thecodeside.news.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsEntity(
    val title: String? = null,
    @SerializedName("abstract")
    val summary: String? = null,
    @SerializedName("url")
    val articleUrl: String? = null,
    val byline: String? = null,
    val publishedDate: String? = null,
    @SerializedName("multimedia")
    val valmediaEntityList: List<MediaEntity>? = null
) : Parcelable