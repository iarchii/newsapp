package news.agoda.com.sample.newslist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import news.agoda.com.sample.model.NewsEntity

class NewsListAdapter(context: Context)  : RecyclerView.Adapter<NewsListViewHolder>(){
    private var newsList: MutableList<NewsEntity> = mutableListOf()

    override fun onBindViewHolder(holder: NewsListViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getData() = newsList.toList()
    fun setData(data: List<NewsEntity>) {
        newsList.clear()
        newsList.addAll(data)
    }

}

