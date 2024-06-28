/*
package jp.ac.it_college_std.s23013.messageboard.presentation.controller

import jp.ac.it_college_std.s23013.messageboard.domain.model.Messages
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageTable
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsEntity
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessagesEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessagesEntity>(MessageTable)

    var threadId by ThreadsEntity referencedOn MessageTable.threadId
    var userId by UsersEntity referencedOn MessageTable.userId
    var message by MessageTable.message
    var postedAt by MessageTable.postedAt
    var updatedAt by MessageTable.updateAt
    var deleted by MessageTable.deleted

    fun toMessage(): Messages {
        return Messages(
            id.value,
            threadId.id.value,
            userId.id.value,
            message,
            postedAt,
            updatedAt,
            deleted
        )
    }
}*/
