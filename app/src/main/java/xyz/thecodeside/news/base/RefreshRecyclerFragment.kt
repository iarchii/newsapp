package xyz.thecodeside.news.base

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import kotlinx.android.synthetic.main.fragment_news_list.*

abstract class RefreshRecyclerFragment<M : List<Parcelable>, V : MvpLceView<M>, P : MvpPresenter<V>, VH : RecyclerView.ViewHolder> : RefreshFragment<M, V, P>() {

    private lateinit var adapter: ListAdapter<M, VH>

    protected abstract fun createAdapter(): ListAdapter<M, VH>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = createAdapter()
        val itemDecorator = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(activity, android.R.drawable.divider_horizontal_bright))
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(itemDecorator)
        recyclerView.adapter = adapter
    }

    override fun setData(data: M) {
        adapter.items = data
        adapter.notifyDataSetChanged()
    }

    override fun getData(): M? = adapter.items

    override fun showContent() {
        if (adapter.itemCount == 0) {
            if (isRestoringViewState) {
                emptyView.visibility = View.VISIBLE
            } else {
                showEmptyAnimation()
            }
        } else {
            emptyView.visibility = View.GONE
        }

        super.showContent()
    }

    private fun showEmptyAnimation() {
        val anim = ObjectAnimator.ofFloat(emptyView, "alpha", 0f, 1f).setDuration(300)
        anim.startDelay = 250
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                emptyView.visibility = View.VISIBLE
            }
        })
        anim.start()
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        if (!pullToRefresh) {
            emptyView.visibility = View.GONE
        }
    }

    override fun showError(e: Throwable, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        if (!pullToRefresh) {
            emptyView.visibility = View.GONE
        }
    }
}

