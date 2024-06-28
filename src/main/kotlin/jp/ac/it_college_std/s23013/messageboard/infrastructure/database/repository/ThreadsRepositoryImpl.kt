package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads
import jp.ac.it_college_std.s23013.messageboard.domain.repository.ThreadsRepository
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsEntity
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class ThreadsRepositoryImpl : ThreadsRepository {
    override fun createThread(thread: Threads): Threads {
        return transaction {
            val newThread = ThreadsEntity.new {
                title = thread.title
                userId = UsersEntity[thread.userId]
                createdAt = thread.createAt
                updatedAt = thread.updateAt
                deleted = thread.deleted
            }
            newThread.toThread()
        }
    }

    override fun getThreadById(id: Long): Threads? {
        return transaction {
            val threadEntity = ThreadsEntity.findById(id)
            threadEntity?.toThread()
        }
    }

    override fun updateThread(thread: Threads): Threads {
        return transaction {
            val threadEntity = ThreadsEntity.findById(thread.id)
                ?: throw IllegalArgumentException("Threads not found with id: ${thread.id}")

            threadEntity.apply {
                title = thread.title
                userId = UsersEntity[thread.userId]
                createdAt = thread.createAt
                updatedAt = thread.updateAt
                deleted = thread.deleted
            }
            threadEntity.toThread()
        }
    }

    override fun deleteThread(id: Long) {
        transaction {
            ThreadsEntity.findById(id)?.delete()
        }
    }
}