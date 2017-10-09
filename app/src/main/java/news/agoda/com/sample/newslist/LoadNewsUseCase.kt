package news.agoda.com.sample.newslist

import news.agoda.com.sample.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource
) {
    fun load() = api.getNews()
}