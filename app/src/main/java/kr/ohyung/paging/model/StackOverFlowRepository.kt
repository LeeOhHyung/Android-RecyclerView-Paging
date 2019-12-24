/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.model

import kr.ohyung.paging.model.remote.StackOverFlowResponse

class StackOverFlowRepository(
    private val mStackOverFlowService: StackOverFlowService
): StackOverFlowService {

    override fun loadStackOverFlowOwners(page: Int, pagesize: Int, site: String): StackOverFlowResponse {
        return mStackOverFlowService.loadStackOverFlowOwners(page, pagesize, site)
    }
}