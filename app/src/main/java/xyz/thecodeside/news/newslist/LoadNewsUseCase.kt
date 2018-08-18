package xyz.thecodeside.news.newslist

import kotlinx.coroutines.experimental.withContext
import xyz.thecodeside.news.dagger.ThreadModule
import xyz.thecodeside.news.helpers.awaitResources
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.model.Resources
import xyz.thecodeside.news.repository.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Named
import kotlin.coroutines.experimental.CoroutineContext

class LoadNewsUseCase @Inject constructor(
        private val api: RemoteDataSource,
        @Named(ThreadModule.BG_CONTEXT)
        private val bgContext: CoroutineContext
) {
    suspend fun load(): Resources<List<NewsEntity>> = withContext(bgContext) {
        val response = api.getNews().awaitResources() //czekaj na odpowiedź
        return@withContext Resources(response.data?.results, response.throwable) //mapowanie na porządany obiekt
    }
}