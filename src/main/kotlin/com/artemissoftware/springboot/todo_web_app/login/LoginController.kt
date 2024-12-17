package com.artemissoftware.springboot.todo_web_app.login

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController(
    private val authenticationService: AuthenticationService
) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping("login", method = [RequestMethod.GET])
    fun goToLoginPage(): String {
        return "login"
    }

    @RequestMapping("login", method = [RequestMethod.POST])
    fun goToWelcomePage(@RequestParam name: String, @RequestParam password: String, model: ModelMap): String {

        return if(authenticationService.authenticate(username = name, password = password)) {
            model["name"] = name
            model["password"] = password
            return "welcome"
        }
        else {
            model["errorMessage"] = "Invalid Credentials"
            "login"
        }
    }

//    @RequestMapping("login")
//    fun goToLoginPage(@RequestParam name: String, model: ModelMap): String {
//        model["name"] = name
//        logger.debug("Request param: $name")
//        return "login"
//    }
}