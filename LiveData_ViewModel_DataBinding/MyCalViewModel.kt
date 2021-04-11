package com.example.viewmodelex
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
// 데이터를
class MyCalViewModel : ViewModel(){
    private val _currentValue = MutableLiveData<Int>()

    val currentValue : LiveData<Int>
    get() = _currentValue

    init {
        _currentValue.value = 0
    }

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