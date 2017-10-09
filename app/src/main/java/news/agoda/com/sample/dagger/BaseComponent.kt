package news.agoda.com.sample.dagger

import dagger.Component


@Component(modules = arrayOf(BaseSystemModule::class, DataModule::class, UtilsModule::class))
interface BaseComponent