package jp.ac.it_college_std.s23013.messageboard.presentation.form

import kotlinx.serialization.Serializable

@Serializable
data class PostUserRegisterRequest(
    val viewName: String,
    val email: String,
    val password: String
)

@Serializable
data class GetUserInfoResponse(
    val id: Long,
    val viewName: String,
)