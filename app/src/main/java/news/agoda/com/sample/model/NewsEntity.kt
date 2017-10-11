package news.agoda.com.sample.model

import com.google.gson.annotations.SerializedName


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
)