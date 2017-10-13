package news.agoda.com.sample.dagger

import android.content.Context
import android.content.res.Resources
import dagger.Component
import news.agoda.com.sample.helpers.Logger
import news.agoda.com.sample.repository.remote.RemoteDataSource
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(BaseSystemModule::class, DataModule::class, UtilsModule::class))
interface BaseComponent{

    fun provideLogger() : Logger
    fun provideRemoteDataSource() : RemoteDataSource
    fun provideContext(): Context
    fun provideResources(): Resources
}