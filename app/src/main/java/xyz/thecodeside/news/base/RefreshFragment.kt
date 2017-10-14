package xyz.thecodeside.news.base

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView

abstract class RefreshFragment<M, V : MvpLceView<M>, P : MvpPresenter<V>> :
        BaseLceFragment<SwipeRefreshLayout, M, V, P>(), MvpLceView<M>, SwipeRefreshLayout.OnRefreshListener {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentView.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        loadData(true)
    }

    override fun showContent() {
        super.showContent()
        contentView.isRefreshing = false
    }

    override fun showError(e: Throwable, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        contentView.isRefreshing = false
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        if (pullToRefresh && !contentView.isRefreshing) {
            // Workaround for measure bug: https://code.google.com/p/android/issues/detail?id=77712
            contentView.post{ contentView.isRefreshing = true }
        }
    }
}
