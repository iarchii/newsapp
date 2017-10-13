package news.agoda.com.sample.newslist

import dagger.Subcomponent
import dagger.android.AndroidInjector
import news.agoda.com.sample.dagger.PerFragment

@PerFragment
@Subcomponent(modules = arrayOf())
interface NewsListComponent : AndroidInjector<NewsListFragment> {

    fun presenter(): NewsListPresenter

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsListFragment>()


}