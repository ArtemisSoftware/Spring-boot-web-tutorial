package com.artemissoftware.springboot.todo_web_app.hello

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    fun sayHello() = "Hello PYT"

    @RequestMapping("say-hello-html")
    @ResponseBody
    fun sayHelloHtml(): String{
        val html = StringBuffer()
        html.append("<html>")
        html.append("<head>")
        html.append("<title>Some title</title>")
        html.append("</head>")
        html.append("<body>")
        html.append("<p>My first paragraph.</p>")
        html.append("</body>")
        html.append("</html>")
        return html.toString()
    }
}