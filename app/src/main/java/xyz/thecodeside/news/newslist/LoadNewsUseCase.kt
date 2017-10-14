package xyz.thecodeside.news.newslist

import io.reactivex.Single
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource
) {
    fun load(): Single<List<NewsEntity>> = api.getNews().map { it.results }
}