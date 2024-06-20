package jp.ac.it_college_std.s23013.messageboard.domain.repository

import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads

interface ThreadsRepository {

    fun createThread(thread: Threads)

    fun getThread(id: Long): Threads?

    fun updateThread(thread: Threads): Threads

    fun deleteThread(id: Long)


}