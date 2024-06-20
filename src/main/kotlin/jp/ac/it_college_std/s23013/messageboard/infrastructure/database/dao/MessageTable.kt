package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object MessageTable: LongIdTable("massage"){
    val threadId = reference("thread_id", ThreadsTable)
    val userId = reference("user_id", UsersTable)
    val message = text("message")
    val postedAt = datetime("posted_at")
    val updateAt = datetime("updated_at")
    val deleted = bool("deleted").default(false)
}