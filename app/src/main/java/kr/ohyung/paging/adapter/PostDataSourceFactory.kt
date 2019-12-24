package kr.ohyung.paging.adapter

import androidx.paging.DataSource
import kr.ohyung.paging.model.local.Post
import kr.ohyung.paging.model.local.PostDao

/**
 * Created by Lee Oh Hyoung on 2019-12-23.
 */
class PostDataSourceFactory(private val mPostDao: PostDao) : DataSource.Factory<Int, Post>() {

    override fun create(): DataSource<Int, Post> {
        return PostDataSource(mPostDao)
    }
}