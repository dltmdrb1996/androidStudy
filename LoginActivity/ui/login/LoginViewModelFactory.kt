package com.example.loginactivity.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginactivity.data.LoginDataSource
import com.example.loginactivity.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
// 뷰모델을 생성하기위한 팩토리패턴
class LoginViewModelFactory : ViewModelProvider.Factory {
    //
    // LoginViewModelFactory을 생성하면 create가 실행되고
    // LoginViewModel을 생성해 반환해준다
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass : Class<T>): T {
        // T 뷰모델 클래스가 LoginViewModel::class.java가 호환되는지 여부를 검사해 boolean 반환
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                    loginRepository = LoginRepository(
                            dataSource = LoginDataSource()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}