package news.agoda.com.sample.dagger

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import news.agoda.com.sample.main.MainActivity
import news.agoda.com.sample.main.MainActivityComponent

@Module(subcomponents = arrayOf(MainActivityComponent::class))
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun mainActivityInjectorFactory(
            builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>



}