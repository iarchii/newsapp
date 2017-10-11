package news.agoda.com.sample.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import news.agoda.com.sample.R
import news.agoda.com.sample.base.ListAdapter
import news.agoda.com.sample.model.NewsEntity

class NewsListAdapter : ListAdapter<List<NewsEntity>,NewsListViewHolder>() {

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(items?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsListViewHolder(inflater.inflate(R.layout.list_item_news, parent, false))
    }
}

