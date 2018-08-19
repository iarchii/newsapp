package xyz.thecodeside.news.newsdetails

import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequest
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_details.*
import xyz.thecodeside.news.R
import xyz.thecodeside.news.base.BaseLceFragment
import xyz.thecodeside.news.helpers.Navigator
import xyz.thecodeside.news.helpers.showToastShort
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.newsdetails.NewsDetailsPresenter.View
import javax.inject.Inject

@FragmentWithArgs
class NewsDetailsFragment : BaseLceFragment<LinearLayout, NewsEntity, View, NewsDetailsPresenter>() {
    companion object {
        const val TAG = "NewsDetailsFragment"
    }

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var detailsPresenter: NewsDetailsPresenter


    @Arg
    lateinit var news: NewsEntity

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showNews()
    }

    private fun showNews() {
        titleTv.text = news.title
        summary_content.text = news.summary
        val imageURL = news.valmediaEntityList?.firstOrNull()?.url.orEmpty()

        val draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(imageURL)))
                .setOldController(news_image.controller).build()
        news_image.controller = draweeController

        full_story_link.setOnClickListener {
            showFullArticle()
        }
        showContent()
    }

    private fun showFullArticle() {
        val uri = presenter.getUri(news.articleUrl)
        uri?.let { navigator.showBrowserForUrl(activity!!, uri) }
                ?: activity!!.showToastShort(R.string.cant_open_article)
    }


    override fun getData(): NewsEntity = news

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String
            = e?.localizedMessage ?: getString(R.string.unknown_error)

    override fun loadData(pullToRefresh: Boolean) {
        //Do nothing?
    }

    override val layoutRes: Int
        get() = R.layout.fragment_details

    override fun createViewState(): LceViewState<NewsEntity, View>
            = RetainingLceViewState<NewsEntity, NewsDetailsPresenter.View>()

    override fun setData(news: NewsEntity) {
        this.news = news
        showNews()
    }

    override fun createPresenter(): NewsDetailsPresenter
            = detailsPresenter


    override fun injectDependencies() {
        super.injectDependencies()
        AndroidSupportInjection.inject(this)
    }


}

