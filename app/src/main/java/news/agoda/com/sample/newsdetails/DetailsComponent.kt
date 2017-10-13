package news.agoda.com.sample.newsdetails

import dagger.Subcomponent
import dagger.android.AndroidInjector
import news.agoda.com.sample.dagger.PerFragment

@PerFragment
@Subcomponent(modules = arrayOf())
interface DetailsComponent : AndroidInjector<NewsDetailsFragment> {

    fun presenter(): NewsDetailsPresenter

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsDetailsFragment>()
}


