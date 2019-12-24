/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.model

import kr.ohyung.paging.model.remote.StackOverFlowResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverFlowService {

    @GET("/2.2/answer/")
    fun loadStackOverFlowOwners(@Query("page") page: Int = 1,
                                @Query("pagesize") pagesize: Int = 50,
                                @Query("site") site: String = "stackoverflow"): StackOverFlowResponse
}