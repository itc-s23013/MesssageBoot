package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads
import jp.ac.it_college_std.s23013.messageboard.domain.repository.ThreadsRepository
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageTable.deleted
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageTable.updateAt
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.MessageTable.userId
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsEntitiy
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsTable.createdAt
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsTable.title
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.ThreadsTable.updatedAt
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class ThreadsRepositoryImpl : ThreadsRepository {
    override fun createThread(thread: Threads) {
        return transaction {
            val newthread = ThreadsEntitiy.new{
                title = thread.title
                userId = UsersEntity[thread.userId]
                createdAt = thread.createAt
                updatedAt = thread.updateAt
                deleted = thread.deleted
            }
        }
    }

    override fun getThread(id: Long): Threads? {
        return transaction {
            val threads = ThreadsEntitiy.findById(id)
            threads?.toTread()
        }
    }

    override fun updateThread(thread: Threads): Threads {
        return transaction {
            val threadsEntitiy = ThreadsEntitiy.findById(thread.id)
                ?: throw IllegalStateException("Threads not found with id: ${thread.id}")

            threadsEntitiy.apply{
                title = thread.title
                userId = UsersEntity[thread.userId]
                createdAt = thread.createAt
                updatedAt = thread.updateAt
                deleted = thread.deleted
            }
            threadsEntitiy.toTread()
        }
    }

    override fun deleteThread(id: Long) {
        transaction {
            ThreadsEntitiy.findById(id)?.deleted
        }
    }
}