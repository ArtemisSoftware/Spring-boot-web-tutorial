package com.artemissoftware.springboot.todo_web_app.todo

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TodoService {

    fun findByUsername(username: String) = TODOS

    private companion object {
        val TODOS = listOf(
            Todo(1, "Milo", "The first one", LocalDate.now().plusYears(1), false),
            Todo(2, "Sorrento", "Poseidon", LocalDate.now().plusYears(2), false),
            Todo(3, "Yoga", "Bronze Saint", LocalDate.now().plusYears(3), false)
        )
    }
}
