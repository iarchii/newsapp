package news.agoda.com.sample.newslist

import io.reactivex.Single
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource
) {
    fun load(): Single<List<NewsEntity>> = api.getNews().map { it.results }
}