package xyz.thecodeside.news.newslist

import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import xyz.thecodeside.news.model.NewsEntity

class NewsListViewState : LceViewState<List<NewsEntity>, NewsListPresenter.View> {
    override fun isPullToRefreshLoadingState(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isLoadingState(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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