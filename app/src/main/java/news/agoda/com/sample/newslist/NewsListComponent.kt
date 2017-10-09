package news.agoda.com.sample.newslist

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.DataModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf( DataModule::class), dependencies = arrayOf(BaseComponent::class))
interface NewsListComponent {

    fun presenter(): NewsListPresenter

    fun inject(fragment: NewsListFragment)
}