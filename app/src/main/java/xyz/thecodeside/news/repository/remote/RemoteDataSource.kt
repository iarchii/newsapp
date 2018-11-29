package xyz.thecodeside.news.repository.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import xyz.thecodeside.news.model.NewsResponse

interface RemoteDataSource {

    @GET("bins/nl6jh")
    fun getNews(): Deferred<NewsResponse>
}
