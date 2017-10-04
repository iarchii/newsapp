package news.agoda.com.sample.model

import news.agoda.com.sample.MediaEntity


data class NewsEntity(
    val title: String? = null,
    val summary: String? = null,
    val articleUrl: String? = null,
    val byline: String? = null,
    val publishedDate: String? = null,
    val valmediaEntityList: List<MediaEntity>? = null
)