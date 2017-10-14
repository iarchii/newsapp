package xyz.thecodeside.news.newslist

import dagger.Subcomponent
import dagger.android.AndroidInjector
import xyz.thecodeside.news.dagger.PerFragment

@PerFragment
@Subcomponent(modules = arrayOf())
interface NewsListComponent : AndroidInjector<NewsListFragment> {

    fun presenter(): NewsListPresenter

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsListFragment>()


}