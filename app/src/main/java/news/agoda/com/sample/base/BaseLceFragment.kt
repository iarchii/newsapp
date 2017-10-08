package news.agoda.com.sample.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.MvpLceViewStateFragment
import icepick.Icepick


/**
 * Base LCE ViewState Fragment for this app that uses Butterknife, Icepick and dependency injection
 *
 * @author Hannes Dorfmann
 */
abstract class BaseLceFragment<CV : View, M, V : MvpLceView<M>, P : MvpPresenter<V>> : MvpLceViewStateFragment<CV, M, V, P>() {

    @get:LayoutRes protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentArgs.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Icepick.restoreInstanceState<BaseLceFragment<CV, M, V, P>>(this, savedInstanceState)
        return inflater!!.inflate(layoutRes, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Icepick.saveInstanceState<BaseLceFragment<CV, M, V, P>>(this, outState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        injectDependencies()
        super.onViewCreated(view, savedInstanceState)
    }


    /**
     * Inject the dependencies
     */
    protected fun injectDependencies() {

    }
}
