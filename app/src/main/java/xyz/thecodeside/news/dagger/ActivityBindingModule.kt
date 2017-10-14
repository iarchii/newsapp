package xyz.thecodeside.news.dagger

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import xyz.thecodeside.news.main.MainActivity
import xyz.thecodeside.news.main.MainActivityComponent

@Module(subcomponents = arrayOf(MainActivityComponent::class))
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun mainActivityInjectorFactory(
            builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>



}