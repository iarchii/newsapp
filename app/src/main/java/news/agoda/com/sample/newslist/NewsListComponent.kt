package news.agoda.com.sample.newslist

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(), dependencies = arrayOf(BaseComponent::class))
interface NewsListComponent {

    fun presenter(): NewsListPresenter

    fun inject(fragment: NewsListFragment)
}