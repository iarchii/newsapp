package news.agoda.com.sample.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.evernote.android.state.StateSaver


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        StateSaver.restoreInstanceState(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState)
    }

    protected open fun injectDependencies() {

    }
}