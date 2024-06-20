package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadsEntitiy (id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ThreadsEntitiy>(ThreadsTable)

    var title by ThreadsTable.title
    var userId by UsersEntity referencedOn ThreadsTable.userId
    var createdAt by ThreadsTable.createdAt
    var updatedAt by ThreadsTable.updatedAt
    var deleted by ThreadsTable.deleted

    fun toTread(): Threads {
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