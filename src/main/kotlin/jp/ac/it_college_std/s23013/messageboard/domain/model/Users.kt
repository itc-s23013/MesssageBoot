package jp.ac.it_college_std.s23013.messageboard.domain.model

import java.time.LocalDateTime

data class Users(
    val id: Long,
    val viewName: String,
    val email: String,
    val password: String
)
