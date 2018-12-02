package xyz.thecodeside.news.newslist

import xyz.thecodeside.news.helpers.awaitResources
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.model.Resources
import xyz.thecodeside.news.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource
) {
    suspend fun load(): Resources<List<NewsEntity>> {
        val response = api.getNews().awaitResources() //czekaj na odpowiedź
        return Resources(response.data?.results, response.throwable) //mapowanie na porządany obiekt
    }
}