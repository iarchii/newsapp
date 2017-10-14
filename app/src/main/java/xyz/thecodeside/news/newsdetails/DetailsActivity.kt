package xyz.thecodeside.news.newsdetails

import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_layout.*
import xyz.thecodeside.news.R
import xyz.thecodeside.news.base.BaseActivity
import xyz.thecodeside.news.model.NewsEntity

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
            val fragment = NewsDetailsFragmentBuilder(news)
                    .build()

            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit()
            
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}