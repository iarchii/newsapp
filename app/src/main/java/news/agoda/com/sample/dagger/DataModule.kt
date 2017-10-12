package news.agoda.com.sample.dagger

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
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

    @Provides
    @Singleton
    fun provideDefaultSharedPrefs(cxt: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(cxt)


}

