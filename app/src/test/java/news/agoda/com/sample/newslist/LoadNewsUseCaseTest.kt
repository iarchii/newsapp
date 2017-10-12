package news.agoda.com.sample.newslist

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import news.agoda.com.sample.helpers.RxTestRule
import news.agoda.com.sample.mock.mockEmptyNews
import news.agoda.com.sample.mock.mockNewsEntity
import news.agoda.com.sample.mock.mockOneNews
import news.agoda.com.sample.repository.remote.RemoteDataSource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoadNewsUseCaseTest{

    @Mock internal lateinit var api: RemoteDataSource

    private lateinit var loadNews: LoadNewsUseCase

    @Rule
    @JvmField
    var rxTestRule: RxTestRule = RxTestRule()

    @Before
    fun setUp() {
        loadNews = LoadNewsUseCase(api)
    }

    @Test
    fun `when load data with empty results then should return empty list`(){
        whenever(api.getNews()).thenReturn(Single.just(mockEmptyNews))
        val testSubscriber = loadNews.load().test()
        testSubscriber.assertComplete()
        testSubscriber.assertValue(emptyList())
    }

    @Test
    fun `when load data with 1 results then should return one element list`(){
        whenever(api.getNews()).thenReturn(Single.just(mockOneNews))
        val testSubscriber = loadNews.load().test()
        testSubscriber.assertComplete()
        testSubscriber.assertValue(listOf(mockNewsEntity))
    }
}