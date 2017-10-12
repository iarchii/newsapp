package news.agoda.com.sample.newsdetails

import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_layout.*
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseActivity
import news.agoda.com.sample.model.NewsEntity

class DetailsActivity : BaseActivity() {
    companion object {
        val KEY_NEWS = "key_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        initToolbar()

        if (savedInstanceState == null) {
            val news = intent.getParcelableExtra<NewsEntity>(KEY_NEWS)

            
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }
}