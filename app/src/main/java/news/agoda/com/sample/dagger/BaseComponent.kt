package news.agoda.com.sample.dagger

import news.agoda.com.sample.dagger.BaseSystemModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(BaseSystemModule::class, DataModule::class, UtilsModule::class))
interface BaseComponent