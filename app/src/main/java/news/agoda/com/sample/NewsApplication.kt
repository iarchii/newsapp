package news.agoda.com.sample

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.DaggerBaseComponent


class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        baseComponent = DaggerBaseComponent.create()
    }

    companion object {

        lateinit var baseComponent: BaseComponent
            private set
    }
}
