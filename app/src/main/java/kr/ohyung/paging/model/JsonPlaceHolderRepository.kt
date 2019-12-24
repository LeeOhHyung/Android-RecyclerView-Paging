/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.model

import io.reactivex.Single
import kr.ohyung.paging.model.local.Post

class JsonPlaceHolderRepository(
    private val mRemoteService: JsonPlaceHolderService
) : JsonPlaceHolderService {

    override fun loadJsonPlaceHolderPosts(): Single<List<Post>> {
        return mRemoteService.loadJsonPlaceHolderPosts()
    }

}