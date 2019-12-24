/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.model.remote

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Owner(@SerializedName("reputation") val reputation: Int,
                 @SerializedName("user_id") val user_id: Int,
                 @SerializedName("profile_image") val profile_image: String,
                 @SerializedName("display_name") val display_name: String) {

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Owner>(){

            override fun areItemsTheSame(oldItem: Owner, newItem: Owner): Boolean {
                return oldItem.user_id == newItem.user_id
            }

            override fun areContentsTheSame(oldItem: Owner, newItem: Owner): Boolean {
                return oldItem == newItem
            }


        }
    }
}