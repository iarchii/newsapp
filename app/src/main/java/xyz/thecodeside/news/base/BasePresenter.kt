package xyz.thecodeside.news.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BasePresenter<V : MvpView> : MvpBasePresenter<V>(), CoroutineScope {

    private val parentJob = Job()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        if (!retainInstance) {
            parentJob.cancel()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob
}