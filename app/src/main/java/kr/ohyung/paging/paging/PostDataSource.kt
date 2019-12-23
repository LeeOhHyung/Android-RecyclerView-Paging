package kr.ohyung.paging.paging

import androidx.paging.ItemKeyedDataSource
import kr.ohyung.paging.model.local.Post

/**
 * Created by Lee Oh Hyoung on 2019-12-23.
 *
 * ItemKeyedDataSource : https://developer.android.com/reference/android/arch/paging/ItemKeyedDataSource.html
 * DataSource : https://developer.android.com/reference/android/arch/paging/DataSource
 */
class PostDataSource : ItemKeyedDataSource<Int, Post>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Post>) {
        // Load initial data.
        val initKey = 1
        val items = makeMockPost(initKey, params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Post>) {
        val items = makeMockPost(params.key + 1, params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Post>) {
    }

    override fun getKey(item: Post): Int {
        return item.id
    }

    private fun makeMockPost(key: Int, size: Int): List<Post> {
        return  ArrayList<Post>().apply {
            for(i in 0 until size) {
                val itemKey = key + i
                add(Post(itemKey, "Content of Key : $itemKey"))
            }
        }
    }
}