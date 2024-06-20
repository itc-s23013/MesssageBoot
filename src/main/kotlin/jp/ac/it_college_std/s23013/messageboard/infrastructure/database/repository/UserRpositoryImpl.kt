package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Users
import jp.ac.it_college_std.s23013.messageboard.domain.repository.UserRpository
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersEntity
import jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao.UsersTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRpositoryImpl : UserRpository {
    override fun findByEmail(email: String): Users? {
        return transaction {
            UsersEntity.find{
                UsersTable.email eq email
            }.singleOrNull()?.toUser()
        }
    }

    override fun findById(id: Long): Users? {
        return transaction {
            UsersEntity.findById(id)?.toUser()
        }
    }
}