package jp.ac.it_college_std.s23013.messageboard.presentation.form

import kotlinx.datetime.LocalDateTime
import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads

data class GetThreadListResponse(
    val threads: List<ThreadsInfo>
)

data class ThreadsInfo(
    val id: Long,
    val title: String,
    val createBy: UserInfo,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val isDeleted: Boolean
){
    constructor(thread: Threads) : this(
        thread.id,
        thread.title,
        UserInfo(thread.createBy.id, thread.createBy.viewName),
        thread.createAt,
        thread.updateAt,
        thread.deleted
    )
}

data class UserInfo(
    val id: Long,
    val viewName: String
)