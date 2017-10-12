package news.agoda.com.sample.dagger

import dagger.Module
import dagger.Provides
import news.agoda.com.sample.helpers.Logger


@Module
class UtilsModule {

    @Provides
    fun provideLogger(): Logger = object : Logger{
        override fun logException(throwable: Throwable) {
            throwable.printStackTrace()
        }
    }

}