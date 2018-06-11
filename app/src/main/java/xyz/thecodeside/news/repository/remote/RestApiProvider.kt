package xyz.thecodeside.news.repository.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.thecodeside.news.BuildConfig
import xyz.thecodeside.news.model.MediaEntity
import xyz.thecodeside.news.repository.remote.deserializers.DateDeserializer
import xyz.thecodeside.news.repository.remote.deserializers.MultimediaDeserializer
import java.util.*
import java.util.concurrent.TimeUnit


class RestApiProvider {

    private val BASE_URL = "https://api.myjson.com/"

    fun provide(): RemoteDataSource {

        val builder = OkHttpClient.Builder()

        builder.connectTimeout(5, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) addLogging(builder)

        val client = builder.build()


        val t =  object : TypeToken<List<@JvmSuppressWildcards MediaEntity>>() {}.type

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .registerTypeAdapter(t, MultimediaDeserializer())
                .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(client)
                .build()

        return retrofit.create(RemoteDataSource::class.java)
    }

    private fun addLogging(builder: OkHttpClient.Builder) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
    }

}

