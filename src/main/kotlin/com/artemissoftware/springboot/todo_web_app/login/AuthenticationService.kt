package com.artemissoftware.springboot.todo_web_app.login

import org.springframework.stereotype.Service

@Service
class AuthenticationService {

    fun authenticate(username: String, password: String) = username == "test" && password == "1234"
}