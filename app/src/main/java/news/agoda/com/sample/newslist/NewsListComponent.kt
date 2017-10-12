package news.agoda.com.sample.newslist

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.DataModule
import news.agoda.com.sample.dagger.UtilsModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf( DataModule::class, UtilsModule::class), dependencies = arrayOf(BaseComponent::class))
interface NewsListComponent {

    fun presenter(): NewsListPresenter

    fun inject(fragment: NewsListFragment)
}