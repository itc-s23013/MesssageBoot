package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadsEntity(id: EntityID<Long> ) : LongEntity(id) {
    companion object : LongEntityClass<ThreadsEntity>(ThreadsTable)

    var title by ThreadsTable.title
    var userId by UsersEntity referencedOn ThreadsTable.userId
    var createdBy by UsersEntity referencedOn ThreadsTable.createdBy
    var createdAt by ThreadsTable.createdAt
    var updatedAt by ThreadsTable.updatedAt
    var deleted by ThreadsTable.deleted

    fun toThread(): Threads{
        return Threads(
            id.value,
            title,
            userId.id.value,
            createdAt,
            updatedAt,
            deleted
        )
    }
}