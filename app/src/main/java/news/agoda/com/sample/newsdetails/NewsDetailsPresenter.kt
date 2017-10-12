package news.agoda.com.sample.newsdetails

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import news.agoda.com.sample.base.RxBasePresenter
import news.agoda.com.sample.helpers.Logger
import news.agoda.com.sample.model.NewsEntity
import javax.inject.Inject

//TODO For now this presenter is not necessary but in more complex app it should be here
class NewsDetailsPresenter @Inject constructor(
        private val logger: Logger

) : RxBasePresenter<NewsDetailsPresenter.View>() {

    interface View : MvpLceView<NewsEntity>

}