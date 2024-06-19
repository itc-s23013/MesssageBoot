package jp.ac.it_college_std.s23013.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UsersEntity (id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UsersEntity>(UsersTable)

    val viewName by UsersTable.view_name
    val email by UsersTable.email
    val password by UsersTable.password
}