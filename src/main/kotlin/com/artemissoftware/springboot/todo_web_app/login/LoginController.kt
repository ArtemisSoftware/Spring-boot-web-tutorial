package com.artemissoftware.springboot.todo_web_app.login

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {

    @RequestMapping("login")
    fun goToLoginPage(@RequestParam name: String, model: ModelMap): String {
        model.put("name", name)
        println("Request param: $name")
        return "login"
    }
}