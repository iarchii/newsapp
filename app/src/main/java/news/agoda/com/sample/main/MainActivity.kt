package news.agoda.com.sample.main

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import com.futuremind.omili.helpers.show
import kotlinx.android.synthetic.main.merge_main_split_pane.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import news.agoda.com.sample.NewsApplication
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseActivity
import news.agoda.com.sample.newslist.NewsDetailsFragment
import news.agoda.com.sample.newslist.NewsListFragment
import news.agoda.com.sample.newslist.NewsListFragmentBuilder


class MainActivity : BaseActivity() {


    private lateinit var mainActivityComponent: MainActivityComponent
    private var listFragment: NewsListFragment? = null
    private var detailsFragment: NewsDetailsFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun injectDependencies() {
        mainActivityComponent = DaggerMainActivityComponent
                .builder().baseComponent(NewsApplication.baseComponent).build()
        mainActivityComponent.inject(this)
    }

    override fun onBackPressed() {
        if (!removeDetailsFragment()) {
            super.onBackPressed()
        }
    }

}