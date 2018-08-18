package xyz.thecodeside.news.dagger

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import javax.inject.Named
import kotlin.coroutines.experimental.CoroutineContext


@Module
class ThreadModule {

    companion object {
        const val BG_CONTEXT = "bg_context"
        const val UI_CONTEXT = "ui_context"
    }

    @Provides
    @Named(BG_CONTEXT)
    fun provideBGContext(): CoroutineContext = CommonPool

    @Provides
    @Named(UI_CONTEXT)
    fun provideUIContext(): CoroutineContext = UI
}