package xyz.thecodeside.news.newslist

import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import kotlinx.coroutines.experimental.Unconfined
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import xyz.thecodeside.news.helpers.Logger
import xyz.thecodeside.news.helpers.RxTestRule
import xyz.thecodeside.news.mock.mockOneNews
import xyz.thecodeside.news.repository.remote.RemoteDataSource


@RunWith(MockitoJUnitRunner::class)
class NewsListPresenterTest {

    @Mock
    private lateinit var api: RemoteDataSource
    @Mock private lateinit var logger: Logger
    @Mock private lateinit var view: NewsListPresenter.View


    private lateinit var presenter: NewsListPresenter

    @Rule
    @JvmField
    var rxTestRule: RxTestRule = RxTestRule()


    @Before
    fun setUp() {
        presenter = NewsListPresenter(LoadNewsUseCase(api, Unconfined), logger, Unconfined)
        presenter.attachView(view)
    }

    @Test
    fun `when error occurs error is showed and exception logged`(){
        whenever(loadNews.load()).thenReturn(Single.error(RuntimeException("error")))

        val pullToRefresh = false

        presenter.loadData(pullToRefresh)

        verify(view, times(1)).showLoading(any())
        verify(view, times(1)).showError(any(), any())
        verify(logger, times(1)).logException(any())
        verifyNoMoreInteractions(view)

    }

    @Test
    fun `when data is loaded content is shown`(){
        whenever(api.getNews()).thenReturn(mockOneNews)

        val pullToRefresh = true
        presenter.loadData(pullToRefresh)

        verify(view, times(1)).showLoading(any())
        verify(view, times(1)).showContent()
        verify(view, times(1)).setData(any())
        verifyNoMoreInteractions(view)

    }

}