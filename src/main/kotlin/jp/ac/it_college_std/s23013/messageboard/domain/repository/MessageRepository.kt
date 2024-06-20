package jp.ac.it_college_std.s23013.messageboard.domain.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Messages


interface MessageRepository {
    fun createMessage(message: Messages): Messages

    fun getMessage(id: Long): Messages?

    fun getMessageByThreadId(threadId: Long): List<Messages>

    fun updateMessage(message: Messages): Messages

    fun deletMessage(id: Long)
}