package xyz.thecodeside.news.main

import dagger.Subcomponent
import dagger.android.AndroidInjector
import xyz.thecodeside.news.dagger.PerActivity


@PerActivity
@Subcomponent(modules = arrayOf())
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}