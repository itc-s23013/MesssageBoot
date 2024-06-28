package jp.ac.it_college.std.s23013.messageboard.presentation.controller

import jp.ac.it_college_std.s23013.messageboard.application.service.UserService
import jp.ac.it_college_std.s23013.messageboard.application.security.MessageBoardUserDetails
import jp.ac.it_college.std.s23013.messageboard.presentation.form.GetUserInfoResponse
import jp.ac.it_college.std.s23013.messageboard.presentation.form.PostUserRegisterRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/register")
    fun register(@RequestBody request: PostUserRegisterRequest) {
        run {
            userService.register(request.viewName, request.email, request.password)
        }
    }

    @GetMapping("/info")
    fun getInfo(
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): GetUserInfoResponse {
        return userService.find(user.getId()).run {
            GetUserInfoResponse(id, viewName)
        }
    }
}