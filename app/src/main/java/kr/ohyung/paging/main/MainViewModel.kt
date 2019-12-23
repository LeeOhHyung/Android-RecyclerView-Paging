/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.ohyung.paging.base.BaseViewModel
import kr.ohyung.paging.model.Post
import kr.ohyung.paging.model.remote.JsonPlaceHolderRepository
import kr.ohyung.paging.paging.PostDataSource
import kr.ohyung.paging.paging.PostDataSourceFactory

class MainViewModel(
    private val mJsonPlaceHolderRepository: JsonPlaceHolderRepository
) : BaseViewModel() {

    companion object {
        private const val TAG: String = "TAG"
    }

//    private val executor = Executors.newFixedThreadPool(5)
    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(10)
        .setPageSize(10)
        .setPrefetchDistance(5)
        .build()

    private val postDataSource: DataSource.Factory<Int, Post> = PostDataSourceFactory()
    val postDataSourceLiveData: LiveData<PagedList<Post>> = LivePagedListBuilder(postDataSource, pagedListConfig).build()

    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData : LiveData<List<Post>> get() = _postsLiveData

    fun loadJsonPlaceHolderPosts(){
        addDisposable(mJsonPlaceHolderRepository.loadJsonPlaceHolderPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->

                Log.d(TAG, "list size : ${list.size}")

                _postsLiveData.postValue(list)

            }, {
                Log.d(TAG, "loadJsonPlaceHolderPosts Failure : ${it.message}")
            }))
    }

}