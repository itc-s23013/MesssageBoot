package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import jp.ac.it_college_std.s23013.messageboard.domain.model.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UsersEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UsersEntity>(UsersTable)

    var viewName by UsersTable.view_name
    var email by UsersTable.email
    var password by UsersTable.password

    fun toUser(): Users {
        return Users(
            id.value,
            viewName,
            email,
            password
        )
    }
}