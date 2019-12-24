/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.adapter

import androidx.paging.PageKeyedDataSource
import kr.ohyung.paging.model.StackOverFlowRepository
import kr.ohyung.paging.model.remote.Owner
import kr.ohyung.paging.model.remote.StackOverFlowResponse

class OwnerDataSource(private val mOwnerRepository: StackOverFlowRepository) : PageKeyedDataSource<Int, Owner>() {

    companion object {
        private const val PAGE_SIZE: Int = 30
        private const val FIRST_PAGE: Int = 1
        private const val TAG: String = "TAG"
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Owner>) {
        val items: StackOverFlowResponse = mOwnerRepository.loadStackOverFlowOwners()
        callback.onResult(items.items, null, FIRST_PAGE + 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Owner>) {
        val adjacentKey: Int? = (if (params.key > 1) params.key - 1 else null)
        val items = mOwnerRepository.loadStackOverFlowOwners()
        callback.onResult(items.items, adjacentKey)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Owner>) {
    }
}