package xyz.thecodeside.news.newslist

import kotlinx.coroutines.Dispatchers.Unconfined
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import xyz.thecodeside.news.helpers.RxTestRule
import xyz.thecodeside.news.repository.remote.RemoteDataSource

@RunWith(MockitoJUnitRunner::class)
class LoadNewsUseCaseTest{

    @Mock internal lateinit var api: RemoteDataSource

    private lateinit var loadNews: LoadNewsUseCase

    @Rule
    @JvmField
    var rxTestRule: RxTestRule = RxTestRule()

    @Before
    fun setUp() {
        loadNews = LoadNewsUseCase(api, Unconfined)
    }

    /*@Test
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
    }*/
}