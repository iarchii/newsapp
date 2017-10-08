package news.agoda.com.sample.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem


import kotlinx.android.synthetic.main.toolbar_layout.*
import news.agoda.com.sample.R

/**
 * A simple abstraction for all activities which are merely fragment containers with a toolbar
 */
abstract class FragmentContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, getFragment(intent))
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) { android.R.id.home -> goUp()}
        return super.onOptionsItemSelected(item)
    }

    abstract fun getFragment(intent: Intent): Fragment
    abstract fun goUp()

}