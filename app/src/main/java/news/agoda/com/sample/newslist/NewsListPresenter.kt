package news.agoda.com.sample.newslist

import com.futuremind.omili.helpers.applyTransformerSingle
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import news.agoda.com.sample.base.RxBasePresenter
import news.agoda.com.sample.helpers.Logger
import news.agoda.com.sample.model.NewsEntity
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val loadNews: LoadNewsUseCase,
        private val logger: Logger

) : RxBasePresenter<NewsListPresenter.View>() {

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

