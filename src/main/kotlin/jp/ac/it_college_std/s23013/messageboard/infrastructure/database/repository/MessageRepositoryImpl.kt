package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Messages
import jp.ac.it_college_std.s23013.messageboard.domain.repository.MessageRepository
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class MessageRepositoryImpl : MessageRepository {
    override fun createMessage(message: Messages): Messages {
        return transaction {
            val newMessage = MessageEntity.new {
                threadId = ThreadsEntitiy[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                updatedAt = message.updateAt
                deleted = message.deleted
            }
            newMessage.toMessage()
        }
    }

    override fun getMessageById(id: Long): Messages? {
        return transaction {
            val message = MessageEntity.findById(id)
            message?.toMessage()
        }
    }

    override fun getMessageByThreadId(threadId: Long): List<Messages> {
        return transaction {
            MessageEntity.find { MessageTable.threadId eq threadId }
                .map { it.toMessage() }
        }
    }

    override fun updateMessage(message: Messages): Messages {
        return transaction {
            val messageEntity = MessageEntity.findById(message.id)
                ?: throw IllegalArgumentException("Message not found with id: ${message.id}")

            messageEntity.apply {
                threadId = ThreadsEntitiy[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                updatedAt = message.updateAt
                deleted = message.deleted
            }

            messageEntity.toMessage()
        }
    }

    override fun deleteMessage(id: Long) {
        transaction {
            MessageEntity.findById(id)?.delete()
        }
    }
}