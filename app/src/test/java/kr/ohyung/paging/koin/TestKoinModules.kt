package kr.ohyung.paging.koin

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Lee Oh Hyoung on 2019-12-24.
 */

val testKoinModules = module {

    single {
        androidApplication()
    }

}