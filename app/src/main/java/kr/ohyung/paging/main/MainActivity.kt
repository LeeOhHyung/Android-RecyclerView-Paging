package kr.ohyung.paging.main

import kr.ohyung.paging.R
import kr.ohyung.paging.base.BaseActivity
import kr.ohyung.paging.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val mViewModel: MainViewModel by viewModel()

    override fun initViewStart() {
    }

    override fun initDataBinding() {
    }

    override fun initViewFinal() {
    }

}
