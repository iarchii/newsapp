package xyz.thecodeside.news.dagger

import dagger.Module
import dagger.Provides
import xyz.thecodeside.news.repository.remote.RestApiProvider
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRemoteRepository() =
            RestApiProvider().provide()

}

