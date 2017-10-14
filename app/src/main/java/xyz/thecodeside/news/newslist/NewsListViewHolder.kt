package xyz.thecodeside.news.newslist

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequest
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.list_item_news.view.*
import xyz.thecodeside.news.model.NewsEntity

class NewsListViewHolder(itemView: View, private val listener: NewsListAdapter.NewsClickedListener)
    : RecyclerView.ViewHolder(itemView) {

    private var newsEntity: NewsEntity? = null
    fun bind(newsEntity: NewsEntity?) {
        this.newsEntity = newsEntity
        itemView.news_title.text = newsEntity?.title

        val draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(newsEntity?.valmediaEntityList?.firstOrNull()?.url ?: "")))
                .setOldController(itemView.news_item_image.controller).build()

        itemView.news_item_image.controller = draweeController

        RxView.clicks(itemView).
                subscribe({
                    newsEntity?.let { listener.onNewsClicked(it) }
                })
    }

}