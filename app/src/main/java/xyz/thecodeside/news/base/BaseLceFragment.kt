package xyz.thecodeside.news.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evernote.android.state.StateSaver
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.MvpLceViewStateFragment

abstract class BaseLceFragment<CV : View, M, V : MvpLceView<M>, P : MvpPresenter<V>> : MvpLceViewStateFragment<CV, M, V, P>() {

    @get:LayoutRes protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentArgs.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        StateSaver.restoreInstanceState(this, savedInstanceState)
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectDependencies()
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Inject the dependencies
     */
    protected open fun injectDependencies() {

    }
}
