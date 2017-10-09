package news.agoda.com.sample.newslist

import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import news.agoda.com.sample.model.NewsEntity

class NewsListViewState : LceViewState<List<NewsEntity>, NewsListPresenter.View> {
    override fun setStateShowError(e: Throwable?, pullToRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun apply(view: NewsListPresenter.View?, retained: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStateShowLoading(pullToRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStateShowContent(loadedData: List<NewsEntity>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}