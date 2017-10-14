package xyz.thecodeside.news.main

import android.animation.LayoutTransition
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.merge_main_split_pane.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import xyz.thecodeside.news.R
import xyz.thecodeside.news.base.BaseActivity
import xyz.thecodeside.news.helpers.show
import xyz.thecodeside.news.model.NewsEntity
import xyz.thecodeside.news.newsdetails.NewsDetailsFragment
import xyz.thecodeside.news.newsdetails.NewsDetailsFragmentBuilder
import xyz.thecodeside.news.newslist.NewsListFragment
import xyz.thecodeside.news.newslist.NewsListFragmentBuilder


class MainActivity : BaseActivity() {

    companion object {
        const val KEY_SHOW_ACTION = "key_show_action"
        const val KEY_SHOW_ACTION_NEWS_DETAILS = "key_show_action_news_details"
        const val KEY_DATA_NEWS_DETAILS = "key_data_news_details"
    }

    private lateinit var mainActivityComponent: MainActivityComponent
    private var listFragment: NewsListFragment? = null
    private var detailsFragment: NewsDetailsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        getPreviousFragments()

        if (detailsFragment != null) {
            rightPane?.show()
        }

        if (paneContainer != null) {
            val transition = LayoutTransition()
            transition.enableTransitionType(LayoutTransition.CHANGING)
            paneContainer?.layoutTransition = transition
        }

        if (listFragment == null) {
            showList(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }


    private fun showList(removeDetailsFragment: Boolean) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.leftPane, NewsListFragmentBuilder().build(), NewsListFragment.TAG)
                .commit()

        if (removeDetailsFragment) {
            removeDetailsFragment()
        }
    }

    private fun removeDetailsFragment(): Boolean {
        val detailsFragment = findDetailsFragment()
        if (detailsFragment != null) {
            rightPane!!.visibility = View.GONE
            supportFragmentManager.beginTransaction().remove(detailsFragment).commit()
            return true
        }

        return false
    }

    private fun getPreviousFragments() {
        detailsFragment = findDetailsFragment()
        listFragment = findNewsListFragment()
    }

    private fun findNewsListFragment() =
            supportFragmentManager.findFragmentByTag(NewsListFragment.TAG) as NewsListFragment?

    private fun findDetailsFragment() =
            supportFragmentManager.findFragmentByTag(NewsDetailsFragment.TAG) as NewsDetailsFragment?

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun onBackPressed() {
        if (!removeDetailsFragment()) {
            super.onBackPressed()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        val showAction = intent.getStringExtra(KEY_SHOW_ACTION)

        if (KEY_SHOW_ACTION_NEWS_DETAILS == showAction) {
            val news = intent.getParcelableExtra<NewsEntity>(KEY_DATA_NEWS_DETAILS)
            showNews(news)
        }
    }

    private fun showNews(news: NewsEntity) {
        rightPane!!.visibility = View.VISIBLE

        val fragment = NewsDetailsFragmentBuilder(news)
                .build()
        supportFragmentManager.beginTransaction()
                .replace(R.id.rightPane, fragment, NewsDetailsFragment.TAG)
                .commit()
    }

}