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

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView

abstract class RefreshFragment<M, V : MvpLceView<M>, P : MvpPresenter<V>> : BaseLceFragment<SwipeRefreshLayout, M, V, P>(), MvpLceView<M>, SwipeRefreshLayout.OnRefreshListener {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentView.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        loadData(true)
    }

    override fun showContent() {
        super.showContent()
        contentView.setRefreshing(false)
    }

    override fun showError(e: Throwable, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        contentView.setRefreshing(false)
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        if (pullToRefresh && !contentView.isRefreshing()) {
            // Workaround for measure bug: https://code.google.com/p/android/issues/detail?id=77712
            contentView.post(Runnable { contentView.setRefreshing(true) })
        }
    }
}
