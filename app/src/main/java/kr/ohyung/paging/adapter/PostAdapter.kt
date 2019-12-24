/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.paging.R
import kr.ohyung.paging.databinding.ListItemPostBinding
import kr.ohyung.paging.model.local.Post
import kr.ohyung.paging.model.local.Post.Companion.DIFF_CALLBACK

/**
 *  DataSource : https://developer.android.com/reference/android/arch/paging/DataSource
 *  DataSource.Factory : https://developer.android.com/reference/androidx/paging/DataSource.Factory.html
 *  PagedList : https://developer.android.com/reference/androidx/paging/PagedList
 */

class PostAdapter : PagedListAdapter<Post, PostAdapter.PostViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int){
        val post: Post? = getItem(position)
        holder.bindTo(post)
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mBinding: ListItemPostBinding? = DataBindingUtil.bind(itemView)

        fun bindTo(post: Post?){
            mBinding?.let { it.post = post }
        }

    }

}