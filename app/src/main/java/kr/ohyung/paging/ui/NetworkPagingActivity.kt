/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.paging.R
import kr.ohyung.paging.adapter.OwnerAdapter
import kr.ohyung.paging.base.BaseActivity
import kr.ohyung.paging.databinding.ActivityNetworkPagingBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class NetworkPagingActivity : BaseActivity<ActivityNetworkPagingBinding, NetworkPagingViewModel>(R.layout.activity_network_paging) {

    override val mViewModel: NetworkPagingViewModel by viewModel()
    private val ownerAdapter: OwnerAdapter by inject()

    override fun initViewStart() {
        mBinding.activityNetworkPagingOwnerRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@NetworkPagingActivity, RecyclerView.VERTICAL, false)
            adapter = ownerAdapter
        }
    }

    override fun initDataBinding() {
    }

    override fun initViewFinal() {
    }
}