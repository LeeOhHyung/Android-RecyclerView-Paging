package kr.ohyung.paging

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kr.ohyung.paging.di.*
import kr.ohyung.paging.koin.testKoinModules
import kr.ohyung.paging.main.MainViewModel
import kr.ohyung.paging.model.local.PostDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
 * Created by Lee Oh Hyoung on 2019-12-24.
 */
class MainViewModelTest : KoinTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mViewModel: MainViewModel by inject()
    private val mPostDatabase: PostDatabase by inject()

    @Before
    fun setUp(){
        startKoin {
            modules(listOf(testKoinModules,
                viewModelModules,
                repositoryModules,
                apiModules,
                dataSourceModules,
                roomModules,
                retrofitModules)
            )
        }
    }

    @After
    fun after(){
        stopKoin()
    }

    @Test
    fun `loadJsonPlaceHolderPosts Test`() {
        mViewModel.loadJsonPlaceHolderPosts()
        assertEquals(2, mViewModel.postsLiveData.value?.size)
    }
}