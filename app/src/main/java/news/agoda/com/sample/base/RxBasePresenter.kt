package news.agoda.com.sample.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class RxBasePresenter<V : MvpView> : MvpBasePresenter<V>() {

    private val subscriptions: CompositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        if(!retainInstance){
            subscriptions.clear()
        }
    }

    fun Disposable.registerInPresenter()   {
        subscriptions.add(this)
    }

}