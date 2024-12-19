package com.artemissoftware.springboot.todo_web_app.todo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Todo(
    @Id
    @GeneratedValue
    var id: Int = 0,
    var username: String = "",
    @field:Size(min = 3, message = "Enter at least 10 characters")
    var description: String = "",
    var targetDate: LocalDate = LocalDate.now(),
    var isDone: Boolean = false
)