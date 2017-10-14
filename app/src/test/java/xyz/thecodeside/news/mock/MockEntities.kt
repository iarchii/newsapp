package xyz.thecodeside.news.mock

import com.google.gson.JsonObject
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.model.NewsResponse


val mockEmptyNews = NewsResponse(emptyList())
val mockNewsEntity = NewsEntity()
val mockOneNews = NewsResponse(listOf(mockNewsEntity))
val mockEmptyJson = JsonObject()

