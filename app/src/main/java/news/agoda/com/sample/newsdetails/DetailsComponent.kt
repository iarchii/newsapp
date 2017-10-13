package news.agoda.com.sample.newsdetails

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.PerActivity

@PerActivity
@Component(modules = arrayOf(), dependencies = arrayOf(BaseComponent::class))
interface DetailsComponent {

    fun presenter(): NewsDetailsPresenter
    fun inject(fragment: NewsDetailsFragment)
}