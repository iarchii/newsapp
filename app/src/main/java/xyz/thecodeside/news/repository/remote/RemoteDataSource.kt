package xyz.thecodeside.news.repository.remote

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import xyz.thecodeside.news.model.NewsResponse

interface RemoteDataSource{

    @GET("bins/nl6jh")
    fun getNews(): Deferred<NewsResponse>
}
