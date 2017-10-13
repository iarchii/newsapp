package news.agoda.com.sample.dagger

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey

import dagger.multibindings.IntoMap
import news.agoda.com.sample.newsdetails.DetailsComponent
import news.agoda.com.sample.newsdetails.NewsDetailsFragment
import news.agoda.com.sample.newslist.NewsListComponent
import news.agoda.com.sample.newslist.NewsListFragment

@Module(subcomponents = arrayOf(NewsListComponent::class, DetailsComponent::class))
abstract class FragmentBindingModule {

        @Binds
        @IntoMap
        @FragmentKey(NewsListFragment::class)
        internal abstract fun newsListFragmentnIjectorFactory(
                builder: NewsListComponent.Builder): AndroidInjector.Factory<out Fragment>

        @Binds
        @IntoMap
        @FragmentKey(NewsDetailsFragment::class)
        internal abstract fun newsDetailsFragmentIjectorFactory(
                builder: DetailsComponent.Builder): AndroidInjector.Factory<out Fragment>


}