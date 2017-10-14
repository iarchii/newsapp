package xyz.thecodeside.news.dagger

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey

import dagger.multibindings.IntoMap
import xyz.thecodeside.news.newsdetails.DetailsComponent
import xyz.thecodeside.news.newsdetails.NewsDetailsFragment
import xyz.thecodeside.news.newslist.NewsListComponent
import xyz.thecodeside.news.newslist.NewsListFragment

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