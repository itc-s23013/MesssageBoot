package jp.ac.it_college_std.s23013.messageboard.application.service.security

import jp.ac.it_college_std.s23013.messageboard.domain.model.Users
import jp.ac.it_college_std.s23013.messageboard.domain.repository.UserRpository
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRpository: UserRpository
) {
    fun createUser(user: Users): Users{
        return userRpository.createUser(user)
    }
}