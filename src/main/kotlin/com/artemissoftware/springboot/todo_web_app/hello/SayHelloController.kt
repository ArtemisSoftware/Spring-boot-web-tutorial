package com.artemissoftware.springboot.todo_web_app.hello

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    fun sayHello() = "Hello PYT"
}