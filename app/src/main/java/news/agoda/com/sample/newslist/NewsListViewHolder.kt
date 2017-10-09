package news.agoda.com.sample.newslist

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequest
import kotlinx.android.synthetic.main.list_item_news.view.*
import news.agoda.com.sample.model.NewsEntity

class NewsListViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {

    lateinit var newsEntity: NewsEntity
    fun bind(newsEntity: NewsEntity) {
        this.newsEntity = newsEntity
        itemView.news_title.text = newsEntity.title

        val draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(newsEntity.valmediaEntityList?.first()?.url)))
                .setOldController(itemView.news_item_image.controller).build()

        itemView.news_item_image.controller = draweeController
    }

}