/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

/**
 * API : https://jsonplaceholder.typicode.com/posts
 */

data class Post(@SerializedName("userId") val userId: Int,
                @SerializedName("id") val id: Int,
                @SerializedName("title") val title: String) {

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Post> =
            object: DiffUtil.ItemCallback<Post>() {
                override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                    return oldItem.equals(newItem)
                }

            }
    }
}