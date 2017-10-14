package xyz.thecodeside.news.base

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.Disposable

abstract class RxViewBasePresenter<V : MvpView> : RxBasePresenter<V>() {
    fun registerSubscription(disposable: Disposable) = disposable.registerInPresenter()
}