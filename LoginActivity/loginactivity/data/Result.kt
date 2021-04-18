package com.example.loginactivity.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
// 로그인 결과를 갖고잇는 클래스
// LoginDataSource 에서의 검증 결과에따라 Success 와 Error 클래스를 골라 사용한다.

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}