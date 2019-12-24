/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.adapter

import androidx.paging.DataSource
import kr.ohyung.paging.model.StackOverFlowRepository
import kr.ohyung.paging.model.remote.Owner

class OwnerDataSourceFactory(private val mOwnerRepository: StackOverFlowRepository) : DataSource.Factory<Int, Owner>() {

    override fun create(): DataSource<Int, Owner> {
        return OwnerDataSource(mOwnerRepository)
    }
}