/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package news.agoda.com.sample.base

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
import news.agoda.com.sample.R

/**
 * @author Hannes Dorfmann
 */
abstract class RefreshRecyclerFragment<M : List<Parcelable>, V : MvpLceView<M>, P : MvpPresenter<V>, VH : RecyclerView.ViewHolder> : RefreshFragment<M, V, P>() {

    private lateinit var adapter: ListAdapter<M, VH>

    protected abstract fun createAdapter(): ListAdapter<M, VH>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = createAdapter()
        val itemDecorator = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(activity, R.drawable.abc_list_divider_mtrl_alpha))
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

