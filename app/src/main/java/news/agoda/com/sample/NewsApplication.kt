package news.agoda.com.sample

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import news.agoda.com.sample.dagger.*


class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        baseComponent = DaggerBaseComponent
                .builder()
                .baseSystemModule(BaseSystemModule(this))
                .dataModule(DataModule())
                .utilsModule(UtilsModule())
                .build()
    }

    companion object {
        lateinit var baseComponent: BaseComponent
            private set
    }
}
