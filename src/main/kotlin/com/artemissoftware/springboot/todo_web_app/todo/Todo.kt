package com.artemissoftware.springboot.todo_web_app.todo

import java.time.LocalDate

class Todo(
    var id: Int,
    var username: String,
    var description: String,
    var targetDate: LocalDate,
    var done: Boolean
)