package com.artemissoftware.springboot.todo_web_app.login

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {

    @RequestMapping("login")
    fun goToLoginPage() = "login"
}