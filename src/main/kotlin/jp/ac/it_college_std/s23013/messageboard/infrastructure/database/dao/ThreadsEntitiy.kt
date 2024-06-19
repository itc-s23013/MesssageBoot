package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadsEntitiy (id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ThreadsEntitiy>(ThreadsTable)

    var title by ThreadsTable.title
    var userId by ThreadsTable.userId
    var createdAt by ThreadsTable.createdAt
    var updatedAt by ThreadsTable.updatedAt
    var deleted by ThreadsTable.deleted
}