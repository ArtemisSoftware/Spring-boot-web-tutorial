package com.artemissoftware.springboot.todo_web_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoWebAppApplication

fun main(args: Array<String>) {
	runApplication<TodoWebAppApplication>(*args)
}
