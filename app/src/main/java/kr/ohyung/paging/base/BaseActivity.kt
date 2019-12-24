/*
 * Created by Lee Oh Hyoung on 2019-12-22 .. 
 */
package kr.ohyung.paging.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.ohyung.paging.R
import kr.ohyung.paging.ui.NetworkPagingActivity
import kr.ohyung.paging.ui.RoomPagingActivity

abstract class BaseActivity<T: ViewDataBinding, VM : BaseViewModel>(private val resourceId: Int) : AppCompatActivity() {

    abstract val mViewModel: VM

    lateinit var mBinding: T

    abstract fun initViewStart()

    abstract fun initDataBinding()

    abstract fun initViewFinal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, resourceId)
        mBinding.lifecycleOwner = this

        initViewStart()
        initDataBinding()
        initViewFinal()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_room_paging -> {
                startActivity(Intent(applicationContext, RoomPagingActivity::class.java))
                return true
            }
            R.id.menu_network_paging -> {
                startActivity(Intent(applicationContext, NetworkPagingActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}