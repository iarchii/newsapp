package news.agoda.com.sample.main

import dagger.Subcomponent
import dagger.android.AndroidInjector
import news.agoda.com.sample.dagger.PerActivity


@PerActivity
@Subcomponent(modules = arrayOf())
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}