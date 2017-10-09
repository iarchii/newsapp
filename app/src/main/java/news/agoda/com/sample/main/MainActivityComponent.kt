package news.agoda.com.sample.main

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import javax.inject.Singleton


@Singleton
@Component(dependencies = arrayOf(BaseComponent::class), modules = arrayOf())
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}