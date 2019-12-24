/*
 * Created by Lee Oh Hyoung on 2019-12-24 .. 
 */
package kr.ohyung.paging.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.ohyung.paging.base.BaseViewModel
import kr.ohyung.paging.model.StackOverFlowRepository
import kr.ohyung.paging.model.remote.StackOverFlowResponse

class NetworkPagingViewModel(
    private val mStackOverFlowRepository: StackOverFlowRepository
) : BaseViewModel() {

    companion object {
        private const val TAG: String = "NetworkPagingViewModel"
    }

    private val _responseLiveData = MutableLiveData<StackOverFlowResponse>()
    val responseLiveData: LiveData<StackOverFlowResponse> get() = _responseLiveData

    fun loadStackOverFlowOwners(){
        addDisposable(
            Observable.just(mStackOverFlowRepository.loadStackOverFlowOwners())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _responseLiveData.postValue(it)

            }, {
                Log.d(TAG, "loadStackOverFlowOwners Failure ${it.message}")
            }))
    }

}