package kr.ohyung.paging.adapter

import androidx.paging.ItemKeyedDataSource
import kr.ohyung.paging.model.local.Post
import kr.ohyung.paging.model.local.PostDao

/**
 * Created by Lee Oh Hyoung on 2019-12-23.
 *
 * ItemKeyedDataSource : https://developer.android.com/reference/android/arch/paging/ItemKeyedDataSource.html
 * DataSource : https://developer.android.com/reference/android/arch/paging/DataSource
 */
class PostDataSource(private val mPostDao: PostDao) : ItemKeyedDataSource<Int, Post>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Post>) {
        // Load initial data.
        val items = mPostDao.loadPosts(requestLoadSize = params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Post>) {
        val items = mPostDao.loadPostsAfter(key = params.key, requestLoadSize = params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Post>) {
    }

    override fun getKey(item: Post): Int = item.id

}