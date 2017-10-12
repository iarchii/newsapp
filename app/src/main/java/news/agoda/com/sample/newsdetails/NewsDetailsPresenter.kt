package news.agoda.com.sample.newsdetails

import android.net.Uri
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import news.agoda.com.sample.base.RxViewBasePresenter
import news.agoda.com.sample.helpers.Logger
import news.agoda.com.sample.model.NewsEntity
import javax.inject.Inject

//TODO For now this presenter is not necessary but in more complex app it should be here
class NewsDetailsPresenter @Inject constructor(
        private val logger: Logger
) : RxViewBasePresenter<NewsDetailsPresenter.View>() {

    interface View : MvpLceView<NewsEntity>

    fun getUri(articleUrl: String?): Uri? =
            parseUri(articleUrl)

    private fun parseUri(articleUrl: String?) =
            try {
                Uri.parse(articleUrl)
            } catch (e: Exception) {
                logger.logException(e)
                null
            }


}