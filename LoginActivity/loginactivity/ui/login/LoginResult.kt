package com.example.loginactivity.ui.login

/**
 * Authentication result : success (user details) or error message.
 */
// 검증 결과를 Livedata로 받긴 위한 데이터
// login() 결과에 따른 Result 의 반환이 저장된다
data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
)