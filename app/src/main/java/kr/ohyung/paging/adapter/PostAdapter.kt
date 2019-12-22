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
import kr.ohyung.paging.model.Post
import kr.ohyung.paging.model.Post.Companion.DIFF_CALLBACK

class PostAdapter : PagedListAdapter<Post, PostAdapter.PostViewHolder>(DIFF_CALLBACK) {

    private val mPosts: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) = holder.bindTo(mPosts[position])

    fun setPosts(list: List<Post>) {
        mPosts.clear()
        mPosts.addAll(list)
        notifyDataSetChanged()
    }

    fun addPost(post: Post) {
        mPosts.add(post)
        notifyDataSetChanged()
    }


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mBinding: ListItemPostBinding? = DataBindingUtil.bind(itemView)

        fun bindTo(post: Post){
            mBinding?.let { it.post = post }
        }

    }

}