package xyz.thecodeside.news.newslist

import xyz.thecodeside.news.base.RxViewBasePresenter
import xyz.thecodeside.news.dagger.ThreadModule
import xyz.thecodeside.news.helpers.Logger
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.repository.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Named
import kotlin.coroutines.experimental.CoroutineContext

class NewsListPresenter @Inject constructor(
        private val loadNews: LoadNewsUseCase,
        private val logger: Logger,
        @Named(ThreadModule.UI_CONTEXT)
        private val uiContext: CoroutineContext,
        private val api: RemoteDataSource,
        @Named(ThreadModule.BG_CONTEXT)
        private val bgContext: CoroutineContext

) : RxViewBasePresenter<NewsListPresenter.View>() {

    interface View : MvpLceView<List<NewsEntity>>

    fun loadData(pullToRefresh: Boolean) {
        launch(uiContext) {
            view?.showLoading(pullToRefresh)
            loadNews.load().apply {
                if (data != null) {
                    view?.run {
                        setData(data)
                        showContent()
                    }
                } else {
                    logger.logException(throwable)
                    view?.showError(throwable, pullToRefresh)
                }
            }
        }
    }
}
