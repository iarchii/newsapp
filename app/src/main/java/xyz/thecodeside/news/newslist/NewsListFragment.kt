package xyz.thecodeside.news.newslist

import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState
import dagger.android.support.AndroidSupportInjection
import xyz.thecodeside.news.R
import xyz.thecodeside.news.base.ListAdapter
import xyz.thecodeside.news.base.RefreshRecyclerFragment
import xyz.thecodeside.news.helpers.Navigator
import xyz.thecodeside.news.model.NewsEntity
import javax.inject.Inject

@FragmentWithArgs
class NewsListFragment : RefreshRecyclerFragment<List<NewsEntity>,
        NewsListPresenter.View, NewsListPresenter, NewsListViewHolder>(),
        NewsListPresenter.View, NewsListAdapter.NewsClickedListener
{

    companion object {
        const val TAG = "NewsListFragment"
    }
    @Inject lateinit var navigator: Navigator
    @Inject lateinit var newsPresenter: NewsListPresenter

    override fun createAdapter(): ListAdapter<List<NewsEntity>, NewsListViewHolder>
            = NewsListAdapter(this)

    override fun createViewState(): LceViewState<List<NewsEntity>, NewsListPresenter.View>
            = RetainingLceViewState<List<NewsEntity>, NewsListPresenter.View>()

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String
            = e?.localizedMessage ?: getString(R.string.unknown_error)

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadData(pullToRefresh)
    }

    override fun createPresenter(): NewsListPresenter = newsPresenter

    override val layoutRes: Int
        get() = R.layout.fragment_news_list

    override fun injectDependencies() {
        super.injectDependencies()
        AndroidSupportInjection.inject(this)
    }

    override fun onNewsClicked(news: NewsEntity) {
        navigator.showNewsDetails(context,news)
    }

}