package kr.ohyung.paging.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.paging.R
import kr.ohyung.paging.adapter.PostAdapter
import kr.ohyung.paging.base.BaseActivity
import kr.ohyung.paging.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val mViewModel: MainViewModel by viewModel()
    private val postAdapter: PostAdapter by inject()

    override fun initViewStart() {
        mBinding.activityMainPostsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = postAdapter
        }
    }

    override fun initDataBinding() {

        mViewModel.postsLiveData.observe(this, Observer { list ->
            list?.let {
                postAdapter.setPosts(it)
            }
        })

    }

    override fun initViewFinal() {

        mViewModel.loadJsonPlaceHolderPosts()
    }

}
