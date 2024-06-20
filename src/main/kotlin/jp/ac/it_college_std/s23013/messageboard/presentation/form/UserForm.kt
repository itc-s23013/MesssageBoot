package jp.ac.it_college_std.s23013.messageboard.presentation.form

import jp.ac.it_college_std.s23013.messageboard.domain.model.Users

data class RegisterUserReqest(
    val viewName: String,
    val email: String,
    val password: String,
){
    fun toModel(): Users {
        return Users(
            id = 0L,
            viewName,
            email,
            password
        )
    }
}