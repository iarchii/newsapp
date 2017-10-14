package xyz.thecodeside.news.repository.remote

import io.reactivex.Single
import xyz.thecodeside.news.model.NewsResponse
import retrofit2.http.GET

interface RemoteDataSource{

    @GET("bins/nl6jh")
    fun getNews() : Single<NewsResponse>
}

