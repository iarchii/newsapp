package xyz.thecodeside.news.dagger

import dagger.BindsInstance
import dagger.Component
import xyz.thecodeside.news.NewsApplication
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        BaseSystemModule::class,
        DataModule::class,
        ThreadModule::class,
        UtilsModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: NewsApplication): Builder
        fun baseSystem(systemModule: BaseSystemModule): Builder
        fun dataModule(dataModule: DataModule): Builder
        fun utilsModule(utilsModule: UtilsModule): Builder
        fun threadModule(threadModule: ThreadModule): Builder

        fun build(): ApplicationComponent
    }

     fun inject(androidApplication: NewsApplication)

}


