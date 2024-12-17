package com.artemissoftware.springboot.todo_web_app.todo

import java.time.LocalDate

data class Todo(
    val id: Int,
    val username: String,
    val description: String,
    val targetDate: LocalDate,
    val done: Boolean
)