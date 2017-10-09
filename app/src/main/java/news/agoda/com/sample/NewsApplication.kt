package news.agoda.com.sample

import android.app.Application
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.DaggerBaseComponent


class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        baseComponent = DaggerBaseComponent.create()
    }

    companion object {

        lateinit var baseComponent: BaseComponent
            private set
    }
}
