/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging

import android.app.Application
import kr.ohyung.paging.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PagingApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PagingApplication)
            modules(listOf(retrofitModules, viewModelModules, apiModules, repositoryModules, adapterModules))
        }
    }

}