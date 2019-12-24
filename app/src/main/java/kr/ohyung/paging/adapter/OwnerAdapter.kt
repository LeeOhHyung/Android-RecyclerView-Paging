/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.paging.R
import kr.ohyung.paging.databinding.ListItemOwnerBinding
import kr.ohyung.paging.model.remote.Owner
import kr.ohyung.paging.model.remote.Owner.Companion.DIFF_CALLBACK

class OwnerAdapter : PagedListAdapter<Owner, OwnerAdapter.OwnerViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwnerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_owner, parent, false)
        return OwnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: OwnerViewHolder, position: Int) {
        val owner: Owner? = getItem(position)

        owner?.let {
            holder.bindTo(it)
        }
    }

    class OwnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mBinding: ListItemOwnerBinding? = DataBindingUtil.bind(itemView)

        fun bindTo(owner: Owner) {
            mBinding?.let {
                it.owner = owner
            }
        }

    }
}