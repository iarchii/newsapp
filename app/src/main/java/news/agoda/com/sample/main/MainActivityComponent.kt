package news.agoda.com.sample.main

import dagger.Component
import news.agoda.com.sample.dagger.BaseComponent
import news.agoda.com.sample.dagger.PerActivity


@PerActivity
@Component(dependencies = arrayOf(BaseComponent::class), modules = arrayOf())
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}