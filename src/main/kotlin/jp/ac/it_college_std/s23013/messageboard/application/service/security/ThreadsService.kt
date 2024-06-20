package jp.ac.it_college_std.s23013.messageboard.application.service.security

import jp.ac.it_college_std.s23013.messageboard.domain.repository.ThreadsRepository
import jp.ac.it_college_std.s23013.messageboard.domain.model.Threads
import org.springframework.stereotype.Service

@Service
class ThreadsService (
    private val threadsRepository: ThreadsRepository
){
    fun createThread(thread: Threads): Threads{
        return threadsRepository.createThread(thread)
    }
}