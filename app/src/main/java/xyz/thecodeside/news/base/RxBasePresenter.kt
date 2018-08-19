package xyz.thecodeside.news.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext


abstract class RxBasePresenter<V : MvpView> : MvpBasePresenter<V>() {

    private var parentJob = Job()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        if (!retainInstance) {
            parentJob.cancel()
        }
    }

    fun RxBasePresenter<V>.launch(context: CoroutineContext = DefaultDispatcher,
                                  start: CoroutineStart = CoroutineStart.DEFAULT,
                                  parent: Job? = null,
                                  onCompletion: CompletionHandler? = null,
                                  block: suspend CoroutineScope.() -> Unit) = kotlinx.coroutines.experimental.launch(
            context = context,
            start = start,
            parent = parent ?: parentJob,
            onCompletion = onCompletion,
            block = block)
}