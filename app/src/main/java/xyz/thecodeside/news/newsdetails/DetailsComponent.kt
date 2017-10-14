package xyz.thecodeside.news.newsdetails

import dagger.Subcomponent
import dagger.android.AndroidInjector
import xyz.thecodeside.news.dagger.PerFragment

@PerFragment
@Subcomponent(modules = arrayOf())
interface DetailsComponent : AndroidInjector<NewsDetailsFragment> {

    fun presenter(): NewsDetailsPresenter

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsDetailsFragment>()
}


