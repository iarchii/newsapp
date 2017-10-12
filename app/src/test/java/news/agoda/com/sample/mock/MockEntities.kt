package news.agoda.com.sample.mock

import com.google.gson.JsonObject
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.model.NewsResponse


val mockEmptyNews = NewsResponse(emptyList())
val mockNewsEntity = NewsEntity()
val mockOneNews = NewsResponse(listOf(mockNewsEntity))
val mockEmptyJson = JsonObject()

