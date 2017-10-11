package news.agoda.com.sample.newslist

import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState
import news.agoda.com.sample.NewsApplication
import news.agoda.com.sample.R
import news.agoda.com.sample.base.ListAdapter
import news.agoda.com.sample.base.RefreshRecyclerFragment
import news.agoda.com.sample.model.NewsEntity

@FragmentWithArgs
class NewsListFragment : RefreshRecyclerFragment<List<NewsEntity>,
        NewsListPresenter.View, NewsListPresenter, NewsListViewHolder>(), NewsListPresenter.View {
    companion object {
        const val TAG = "NewsListFragment"
    }

    private lateinit var newsListComponent: NewsListComponent


    override fun createAdapter(): ListAdapter<List<NewsEntity>, NewsListViewHolder>
            = NewsListAdapter()


    override fun createViewState(): LceViewState<List<NewsEntity>, NewsListPresenter.View>
            = RetainingLceViewState<List<NewsEntity>, NewsListPresenter.View>()

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String
            = e?.localizedMessage ?: getString(R.string.unknown_error)

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadData(pullToRefresh)
    }

    override fun createPresenter(): NewsListPresenter = newsListComponent.presenter()

    override val layoutRes: Int
        get() = R.layout.fragment_news_list


    override fun injectDependencies() {
        super.injectDependencies()
        newsListComponent = DaggerNewsListComponent.builder()
                .baseComponent(NewsApplication.baseComponent)
                .build()
        newsListComponent.inject(this)
    }


}

