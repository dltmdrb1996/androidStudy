package com.example.loginactivity.data

import com.example.loginactivity.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
// 로그인 검증후 결과값을 반환
// 인증 서버와의 연결후 세부 코드 작성이 필요하다.
// 현재는 아무 검증 없이 가상의 LoggedInUser(사용자정보)를 반환한다.
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}