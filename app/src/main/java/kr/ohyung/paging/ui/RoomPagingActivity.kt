package kr.ohyung.paging.ui

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.paging.R
import kr.ohyung.paging.adapter.PostAdapter
import kr.ohyung.paging.base.BaseActivity
import kr.ohyung.paging.databinding.ActivityRoomPagingBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomPagingActivity : BaseActivity<ActivityRoomPagingBinding, RoomPagingViewModel>(R.layout.activity_room_paging) {

    override val mViewModel: RoomPagingViewModel by viewModel()
    private val postAdapter: PostAdapter by inject()

    override fun initViewStart() {
        mBinding.activityMainRoomPagingRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RoomPagingActivity, RecyclerView.VERTICAL, false)
            adapter = postAdapter
        }
    }

    override fun initDataBinding() {

        mViewModel.postsLiveData.observe(this, Observer { list ->
            list?.let {
                mViewModel.insertRoomPosts(it)
            }
        })

        mViewModel.postDataSourceLiveData.observe(this, Observer { pagedList ->
            pagedList?.let {
                postAdapter.submitList(it)
            }
        })

    }

    override fun initViewFinal() {

        mViewModel.loadJsonPlaceHolderPosts()
    }

}
