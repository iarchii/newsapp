package news.agoda.com.sample.newslist

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.PerActivity

@PerActivity
@Component(modules = arrayOf(), dependencies = arrayOf(BaseComponent::class))
interface NewsListComponent {

    fun presenter(): NewsListPresenter

    fun inject(fragment: NewsListFragment)
}