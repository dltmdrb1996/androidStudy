package com.example.loginactivity.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.loginactivity.data.LoginRepository
import com.example.loginactivity.data.Result

import com.example.loginactivity.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {


    // 값의 변경을 위한 내부 사용을 위한 변수 _
    private val _loginForm = MutableLiveData<LoginFormState>()
    // LiveData observe 를 위한 변수
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult


    // 로그인 실행
    fun login(username: String, password: String) {
        // 로그인 인증 절차 실행 Result.success 혹은 error 를 반환
        val result = loginRepository.login(username, password)

        // 로그인 결과에따라 내부 livedata가 변경되고 view에 observe 가 작동
        if (result is Result.Success) {
            _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    // 사용자가 id와 passwd를 작성하면 리스너를 통해 실행되서
    // viewmodel내부의 데이터를 변경 livedata를 동작시킨다.
    // id와 passwd의 지정양식을 검토한다
    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // id 양식조건
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // passwd 양식 조건
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}