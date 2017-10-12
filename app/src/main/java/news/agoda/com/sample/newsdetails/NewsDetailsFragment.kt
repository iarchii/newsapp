package news.agoda.com.sample.newsdetails

import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequest
import com.futuremind.omili.helpers.showToastShort
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_details.*
import news.agoda.com.sample.NewsApplication
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseLceFragment
import news.agoda.com.sample.helpers.IntentStarter
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.newsdetails.NewsDetailsPresenter.View
import javax.inject.Inject

@FragmentWithArgs
class NewsDetailsFragment : BaseLceFragment<LinearLayout, NewsEntity, View, NewsDetailsPresenter>() {
    companion object {
        const val TAG = "NewsDetailsFragment"
    }

    @Inject lateinit var intentStarter: IntentStarter
    private lateinit var detailsComponent: DetailsComponent

    @Arg
    lateinit var news: NewsEntity

    override fun onViewCreated(view: android.view.View?, savedInstanceState: Bundle?) {
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

        presenter.registerSubscription(
                RxView.clicks(full_story_link)
                .subscribe({
                    showFullArticle()
                }))

        showContent()
    }

    private fun showFullArticle() {
        if (news.articleUrl.isNullOrEmpty()) {
            activity.showToastShort(R.string.cant_open_article)
        } else {
            intentStarter.showBrowserForUrl(activity, news.articleUrl!!)
        }
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
            = detailsComponent.presenter()


    override fun injectDependencies() {
        super.injectDependencies()
        detailsComponent = DaggerDetailsComponent.builder()
                .baseComponent(NewsApplication.baseComponent)
                .build()
        detailsComponent.inject(this)
    }


}

