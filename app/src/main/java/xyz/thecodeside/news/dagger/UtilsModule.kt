package xyz.thecodeside.news.dagger

import dagger.Module
import dagger.Provides
import xyz.thecodeside.news.helpers.Logger


@Module
class UtilsModule {

    @Provides
    fun provideLogger(): Logger = object : Logger{
        override fun logException(throwable: Throwable) {
            throwable.printStackTrace()
        }
    }

}