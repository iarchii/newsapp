package news.agoda.com.sample.newslist

import android.support.v4.widget.SwipeRefreshLayout
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import news.agoda.com.sample.NewsEntity
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseLceFragment
import news.agoda.com.sample.base.RxBasePresenter

@FragmentWithArgs
class NewsListFragment : BaseLceFragment<SwipeRefreshLayout,List<NewsEntity>,
        NewsListPresenter.View, NewsListPresenter>(){
    companion object {
        const val TAG = "NewsListFragment"
    }

    override fun createViewState(): LceViewState<List<NewsEntity>, NewsListPresenter.View> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean)
        = e?.localizedMessage ?: getString(R.string.unknown_error)



    override fun getData(): List<NewsEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(data: List<NewsEntity>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadData(pullToRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): NewsListPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | Fi
        // le Templates.
    }

    override val layoutRes: Int
        get() = R.layout.fragment_news_list



}

class NewsListPresenter : RxBasePresenter<NewsListPresenter.View>()
{
    interface View :MvpLceView<List<NewsEntity>>{

    }

}
