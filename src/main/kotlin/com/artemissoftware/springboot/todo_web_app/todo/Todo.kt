package com.artemissoftware.springboot.todo_web_app.todo

import jakarta.validation.constraints.Size
import java.time.LocalDate

data class Todo(
    var id: Int = 0,
    var username: String = "",
    @field:Size(min = 3, message = "Enter at least 10 characters")
    var description: String = "",
    var targetDate: LocalDate = LocalDate.now(),
    var isDone: Boolean = false
)