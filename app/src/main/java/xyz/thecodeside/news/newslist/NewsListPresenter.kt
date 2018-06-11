package xyz.thecodeside.news.newslist

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import xyz.thecodeside.news.base.RxViewBasePresenter
import xyz.thecodeside.news.helpers.Logger
import xyz.thecodeside.news.model.NewsEntity
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
    private val loadNews: LoadNewsUseCase,
    private val logger: Logger

) : RxViewBasePresenter<NewsListPresenter.View>() {

  interface View : MvpLceView<List<NewsEntity>>

  fun loadData(pullToRefresh: Boolean) {
    view?.showLoading(pullToRefresh)
    var result: List<NewsEntity>
    launch {
      result = try {
        val result = loadNews.load().await().results
        view?.setData(result)
        withContext(UI) {
          view?.showContent()
        }
        result
      } catch (e: Throwable) {
        logger.logException(e)
        withContext(UI) {
          view?.showError(e, pullToRefresh)
        }
        emptyList()
      }

    }.registerInPresenter()

    /*loadNews.load()
            .compose(applyTransformerSingle())
            .subscribe({
                view?.setData(it)
                view?.showContent()
            }, {
                logger.logException(it)
                view?.showError(it, pullToRefresh)
            }).registerInPresenter()*/
  }

}

