package news.agoda.com.sample.repository.remote

import com.google.gson.GsonBuilder
import news.agoda.com.sample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RestApiProvider {

    private val ISO_DATE = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private val BASE_URL= "https://api.myjson.com/"

    fun provide(): RemoteDataSource {

        val builder = OkHttpClient.Builder()

        builder.connectTimeout(5, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) addLogging(builder)

        val client = builder.build()

        val gson = GsonBuilder().setDateFormat(ISO_DATE).create()

        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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

