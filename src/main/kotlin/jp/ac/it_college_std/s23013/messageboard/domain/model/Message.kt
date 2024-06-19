package jp.ac.it_college_std.s23013.messageboard.domain.model

import java.time.LocalDateTime

data class Message(
    val id: Long,
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val deleted: Boolean
)
