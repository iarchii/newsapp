package news.agoda.com.sample.dagger

import dagger.Module
import dagger.Provides
import news.agoda.com.sample.repository.remote.RestApiProvider
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRemoteRepository() =
            RestApiProvider().provide()

}

