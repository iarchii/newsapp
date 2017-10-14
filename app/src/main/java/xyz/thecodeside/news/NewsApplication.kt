package xyz.thecodeside.news

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import xyz.thecodeside.news.dagger.BaseSystemModule
import xyz.thecodeside.news.dagger.DaggerApplicationComponent
import xyz.thecodeside.news.dagger.DataModule
import xyz.thecodeside.news.dagger.UtilsModule
import javax.inject.Inject


class NewsApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {



    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
    @Inject
    lateinit var dispatchingAndroidInjectorFragment: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjectorFragment


    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        DaggerApplicationComponent
                .builder()
                .application(this)
                .baseSystem(BaseSystemModule(this))
                .dataModule(DataModule())
                .utilsModule(UtilsModule())
                .build()
                .inject(this)
    }


}
