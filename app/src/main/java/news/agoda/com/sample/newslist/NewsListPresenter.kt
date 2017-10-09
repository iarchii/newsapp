package news.agoda.com.sample.newslist

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import news.agoda.com.sample.base.RxBasePresenter
import news.agoda.com.sample.model.NewsEntity
import javax.inject.Inject

class NewsListPresenter @Inject constructor() : RxBasePresenter<NewsListPresenter.View>() {

    interface View : MvpLceView<List<NewsEntity>> {
        fun test()
    }

    fun loadData(pullToRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}