package xyz.thecodeside.news.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.Job


abstract class RxBasePresenter<V : MvpView> : MvpBasePresenter<V>() {

  private val subscriptions: CompositeDisposable = CompositeDisposable()

  var job: Job? = null

  override fun detachView(retainInstance: Boolean) {
    super.detachView(retainInstance)
    if (!retainInstance) {
      subscriptions.clear()
      job?.cancel()
    }
  }

  fun Disposable.registerInPresenter() {
    subscriptions.add(this)
  }

  fun Job.registerInPresenter() {
    job = this
  }

}