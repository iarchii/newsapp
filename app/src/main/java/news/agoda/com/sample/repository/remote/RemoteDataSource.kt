package news.agoda.com.sample.repository.remote

import io.reactivex.Single
import news.agoda.com.sample.model.NewsEntity
import retrofit2.http.GET

interface RemoteDataSource{

    @GET("bins/nl6jh")
    fun getNews() : Single<List<NewsEntity>>
}

