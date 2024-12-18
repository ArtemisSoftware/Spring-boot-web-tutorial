package com.artemissoftware.springboot.todo_web_app.login

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.security.core.Authentication;


@Controller
@SessionAttributes("name")
class WelcomeController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping("/", method = [RequestMethod.GET])
    fun goToWelcomePage(model: ModelMap): String {
        model["name"] = getLoggedinUsername()
        return "welcome"
    }

    private fun getLoggedinUsername(): String {
        val authentication = SecurityContextHolder.getContext().authentication
        return authentication.name
    }
}