package com.artemissoftware.springboot.todo_web_app.todo

import java.time.LocalDate

class Todo(
    var id: Int = 0,
    var username: String = "",
    var description: String = "",
    var targetDate: LocalDate = LocalDate.now(),
    var done: Boolean = false
)