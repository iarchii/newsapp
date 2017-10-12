package news.agoda.com.sample.helpers

import android.content.Context
import android.content.Intent
import android.net.Uri
import news.agoda.com.sample.R
import news.agoda.com.sample.main.MainActivity
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.newsdetails.DetailsActivity
import javax.inject.Inject


class IntentStarter @Inject constructor(
) {

    private fun isTablet(context: Context): Boolean = context.resources.getBoolean(R.bool.tablet)

    fun showNewsDetails(context: Context, news: NewsEntity) =
            context.startActivity(getNewsDetailsIntent(context, news))

    private fun getNewsDetailsIntent(context: Context, news: NewsEntity): Intent =
            if (isTablet(context)) {
                getShowNewsInSameActivityIntent(context, news)
            } else {
                getShowNewsInNewActivityIntent(context, news)
            }

    private fun getShowNewsInSameActivityIntent(context: Context, news: NewsEntity): Intent {
        val i = Intent(context, MainActivity::class.java)
        i.putExtra(MainActivity.KEY_SHOW_ACTION, MainActivity.KEY_SHOW_ACTION_NEWS_DETAILS)
        i.putExtra(MainActivity.KEY_DATA_NEWS_DETAILS, news)
        return i
    }

    private fun getShowNewsInNewActivityIntent(context: Context, news: NewsEntity): Intent {
        val i = Intent(context,DetailsActivity::class.java)
        i.putExtra(DetailsActivity.KEY_NEWS,news)
        return i
    }

    fun showBrowserForUrl(context: Context, url : String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    }



}

