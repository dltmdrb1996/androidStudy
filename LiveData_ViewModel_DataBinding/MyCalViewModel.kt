package com.example.viewmodelex
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCalViewModel : ViewModel(){
    // 데이터의 변경이 이루어지는 내부 변수 
    // 원하는 데이터값은 private에 저장하고 
    // 실질적인 View의 변경을 외부변수를 통해 livedata를 통해 함으로서
    // 뷰모델을 거치지않은 View의 변경을 막아준다
    private val _currentValue = MutableLiveData<Int>()

    //라이브데이타를 통한 실질적인 데이터의 변경에 작용하는 외부변수 
    val currentValue : LiveData<Int>
    get() = _currentValue 

    init {
        _currentValue.value = 0
    }

    // View에게 data변경을 요청받기위한 함수
    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.SUM -> _currentValue.value = _currentValue.value?.plus(input)
            ActionType.SUB -> _currentValue.value = _currentValue.value?.minus(input)
        }
        Log.d("test","현재 _currentValue 값 ${_currentValue.value}")
    }
}

enum class ActionType(){
    SUM,
    SUB
}
