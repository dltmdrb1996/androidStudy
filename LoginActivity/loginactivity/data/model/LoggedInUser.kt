package com.example.loginactivity.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
// 사용자 정보를 담는 데이터
data class LoggedInUser(
        val userId: String,
        val displayName: String
)