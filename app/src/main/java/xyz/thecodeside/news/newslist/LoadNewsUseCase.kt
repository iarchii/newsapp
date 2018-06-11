package xyz.thecodeside.news.newslist

import kotlinx.coroutines.experimental.Deferred
import xyz.thecodeside.news.model.NewsResponse
import xyz.thecodeside.news.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource
) {
    fun load(): Deferred<NewsResponse> = api.getNews()
}