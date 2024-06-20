package jp.ac.it_college_std.s23013.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class Threads(
    val id: Long,
    val title: String,
    val userId: Long,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val deleted: Boolean
)
