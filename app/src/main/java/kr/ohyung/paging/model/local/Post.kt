/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.model.local

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * API : https://jsonplaceholder.typicode.com/posts
 */

@Entity(tableName = "posts")
data class Post(@PrimaryKey(autoGenerate = true)
           @SerializedName("id") val id: Int,
           @SerializedName("title") val title: String) {

    companion object {
        // DiffUtil을 통해 비교 후, 변경된 값이 변한 아이템들만 변경합니다.
        // 이때 비교 연산은 별도의 background 스레드에서 실행되고, 그 결과를 기반으로 main 스레드에서 UI 작업을 수행함.
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