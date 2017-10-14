package xyz.thecodeside.news.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import xyz.thecodeside.news.R
import xyz.thecodeside.news.base.ListAdapter
import xyz.thecodeside.news.model.NewsEntity

class NewsListAdapter(private val listener: NewsClickedListener) : ListAdapter<List<NewsEntity>,NewsListViewHolder>() {

    interface NewsClickedListener {
        fun onNewsClicked(news: NewsEntity)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(items?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_news, parent, false)
        return NewsListViewHolder(view, listener )
    }
}

