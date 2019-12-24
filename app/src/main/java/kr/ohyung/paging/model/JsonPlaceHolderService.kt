/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.model

import io.reactivex.Single
import kr.ohyung.paging.model.local.Post
import retrofit2.http.GET

interface JsonPlaceHolderService {

    @GET("/posts")
    fun loadJsonPlaceHolderPosts(): Single<List<Post>>

}