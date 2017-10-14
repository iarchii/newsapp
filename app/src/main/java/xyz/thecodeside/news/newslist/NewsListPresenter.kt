package xyz.thecodeside.news.newslist

import xyz.thecodeside.news.helpers.applyTransformerSingle
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import xyz.thecodeside.news.base.RxViewBasePresenter
import xyz.thecodeside.news.helpers.Logger
import xyz.thecodeside.news.model.NewsEntity
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val loadNews: LoadNewsUseCase,
        private val logger: Logger

) : RxViewBasePresenter<NewsListPresenter.View>() {

    interface View : MvpLceView<List<NewsEntity>>

    fun loadData(pullToRefresh: Boolean) {
        view?.showLoading(pullToRefresh)
        loadNews.load()
                .compose(applyTransformerSingle())
                .subscribe({
                    view?.setData(it)
                    view?.showContent()
                }, {
                    logger.logException(it)
                    view?.showError(it, pullToRefresh)
                }).registerInPresenter()
    }

}

