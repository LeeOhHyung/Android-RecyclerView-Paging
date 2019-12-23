/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kr.ohyung.paging.BuildConfig
import kr.ohyung.paging.paging.PostAdapter
import kr.ohyung.paging.main.MainViewModel
import kr.ohyung.paging.model.remote.JsonPlaceHolderRepository
import kr.ohyung.paging.model.remote.JsonPlaceHolderService
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://jsonplaceholder.typicode.com"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L
private const val CACHE_SIZE = 10L * 1024 * 1024

val retrofitModules = module {

    single {
        Cache(androidApplication().cacheDir, CACHE_SIZE)
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        OkHttpClient.Builder()
            .cache(get())
            .addNetworkInterceptor(get<Interceptor>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().build())
        }
    }

    single {
        HttpLoggingInterceptor().apply {
            when(BuildConfig.DEBUG) {
                true -> run { level = HttpLoggingInterceptor.Level.BODY }
                false -> run { level = HttpLoggingInterceptor.Level.NONE }
            }
        }
    }

}

val viewModelModules = module {

    viewModel {
        MainViewModel(get())
    }

}

val apiModules = module {

    single {
        get<Retrofit>().create(JsonPlaceHolderService::class.java)
    }
}

val repositoryModules = module {

    single {
        JsonPlaceHolderRepository(get())
    }
}

val adapterModules = module {

    factory {
        PostAdapter()
    }
}