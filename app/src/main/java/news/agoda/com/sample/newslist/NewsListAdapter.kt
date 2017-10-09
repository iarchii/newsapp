package news.agoda.com.sample.newslist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import news.agoda.com.sample.R
import news.agoda.com.sample.model.NewsEntity

class NewsListAdapter(context: Context)  : RecyclerView.Adapter<NewsListViewHolder>(){
    private var newsList: MutableList<NewsEntity> = mutableListOf()

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount() = newsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsListViewHolder(inflater.inflate(R.layout.list_item_news, parent, false))
    }

    fun getData() = newsList.toList()
    fun setData(data: List<NewsEntity>) {
        newsList.clear()
        newsList.addAll(data)
    }

}

