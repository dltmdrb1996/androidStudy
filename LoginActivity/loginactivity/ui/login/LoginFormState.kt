package com.example.loginactivity.ui.login

/**
 * Data validation state of the login form.
 */
// 지정된 양식에 맞는 데이터인지 검사하기위한 데이터
// 뷰모델을 통해 변경되며 livedata를 통해
// 각각 id와 passwd를 검증한뒤 에러가없으면 isDataValid true값을 넣어준다
data class LoginFormState(val usernameError: Int? = null,
                          val passwordError: Int? = null,
                          val isDataValid: Boolean = false)