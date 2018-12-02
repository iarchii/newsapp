package xyz.thecodeside.news.newslist

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import xyz.thecodeside.news.base.BasePresenter
import xyz.thecodeside.news.dagger.ThreadModule
import xyz.thecodeside.news.helpers.Logger
import xyz.thecodeside.news.model.NewsEntity
import javax.inject.Inject
import javax.inject.Named
import kotlin.coroutines.CoroutineContext

class NewsListPresenter @Inject constructor(
        private val loadNews: LoadNewsUseCase,
        private val logger: Logger,
        @Named(ThreadModule.UI_CONTEXT)
        private val uiContext: CoroutineContext,
        @Named(ThreadModule.BG_CONTEXT)
        private val bgContext: CoroutineContext

) : BasePresenter<NewsListPresenter.View>() {

    interface View : MvpLceView<List<NewsEntity>>

    fun loadData(pullToRefresh: Boolean) {
        launch(uiContext) {
            view?.showLoading(pullToRefresh)
            withContext(bgContext) {
                loadNews.load()
            }.apply {
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
