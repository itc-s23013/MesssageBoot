package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Messages
import jp.ac.it_college_std.s23013.messageboard.domain.repository.MessageRepository
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageEntity
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageTable
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsEntitiy
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class MessageRpositoryImpl : MessageRepository {
    override fun createMessage(message: Messages): Messages {
        return transaction {
            val newMessages = MessageEntity.new {
                threadId = ThreadsEntitiy[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                deleted = message.deleted
            }
            newMessages.toMessage()
        }
    }

    override fun getMessage(id: Long): Messages? {
        return transaction {
            val messageEntity = MessageEntity.findById(id)
            messageEntity?.toMessage()
        }
    }

    override fun getMessageByThreadId(threadId: Long): List<Messages> {
        return transaction {
            MessageEntity.find{
                MessageTable.threadId eq threadId
            }.map { it.toMessage() }
        }
    }

    override fun updateMessage(message: Messages): Messages {
        return transaction {
            val messageEntity = MessageEntity.findById(message.id)
                ?: throw IllegalArgumentException("更新箇所が見つかりません ${message.id}")
            messageEntity.apply {
                threadId = ThreadsEntitiy[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                deleted = message.deleted
            }

            messageEntity.toMessage()
        }
    }

    override fun deletMessage(id: Long) {
        transaction {
            MessageEntity.findById(id)?.delete()
        }
    }
}
