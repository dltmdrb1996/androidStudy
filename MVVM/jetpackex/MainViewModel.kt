package com.example.jetpackex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //////////////////////////////////////////////////////////////////////////////////////////
    // 액티비티 관찰 영역
    //////////////////////////////////////////////////////////////////////////////////////////
    private val _currentFragment = MutableLiveData<Int>()

    val currentFragment: LiveData<Int>
        get() = _currentFragment

    fun changeFragment(fragmentId: Int) {
        _currentFragment.value = fragmentId
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // 홈프래그먼트 관찰 영역
    //////////////////////////////////////////////////////////////////////////////////////////
    private val _homeTitle = MutableLiveData<String>()

    val homeTitle: LiveData<String>
        get() = _homeTitle

    fun setHomeTitle(title: String) {
        _homeTitle.value = title
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // 두번쨰 프래그먼트 관찰 영역
    //////////////////////////////////////////////////////////////////////////////////////////
    private val _secondTitle = MutableLiveData<String>()

    val secondTitle: LiveData<String>
        get() = _secondTitle

    fun setSecondTitle(title: String) {
        _secondTitle.value = title
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // 세번쨰프래그먼트 관찰 영역
    //////////////////////////////////////////////////////////////////////////////////////////
    private val _thirdTitle = MutableLiveData<String>()

    val thirdTitle: LiveData<String>
        get() = _thirdTitle

    fun setThirdTitle(title: String) {
        _thirdTitle.value = title
    }
}

