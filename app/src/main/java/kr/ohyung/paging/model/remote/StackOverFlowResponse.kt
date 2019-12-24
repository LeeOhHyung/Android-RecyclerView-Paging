/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.model.remote

import com.google.gson.annotations.SerializedName

data class StackOverFlowResponse(@SerializedName("items") val items: List<Owner>)