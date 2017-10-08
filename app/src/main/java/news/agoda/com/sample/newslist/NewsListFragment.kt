package news.agoda.com.sample.newslist

import android.support.v4.widget.SwipeRefreshLayout
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import news.agoda.com.sample.NewsEntity
import news.agoda.com.sample.base.BaseLceFragment
import news.agoda.com.sample.base.RxBasePresenter
import javax.inject.Inject


class NewsListFragment : BaseLceFragment<SwipeRefreshLayout,List<NewsEntity>,NewsListPresenter.View, NewsListPresenter>(){
    override fun createViewState(): LceViewState<List<NewsEntity>, NewsListPresenter.View> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getData(): List<NewsEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(data: List<NewsEntity>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
Ń
    override fun loadData(pullToRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): NewsListPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val layoutRes: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.



}

class NewsListPresenter : RxBasePresenter<NewsListPresenter.View>()
{
    interface View :MvpLceView<List<NewsEntity>>{

    }

}
