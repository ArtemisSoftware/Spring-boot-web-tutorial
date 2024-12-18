package com.artemissoftware.springboot.todo_web_app.todo

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TodoService {

    fun findByUsername(username: String) = TODOS

    fun addTodo(username: String, description: String, localDate: LocalDate, done: Boolean){
        val id = TODOS.last().id + 1
        val todo = Todo(id, username, description, localDate, done)
        TODOS.add(todo)
    }

    fun deleteById(id: Int){
        TODOS.removeIf { it.id == id }
    }

    fun findById(id: Int): Todo? {
        return TODOS.find { it.id == id }
    }

    fun update(todo: Todo) {
        TODOS.find { it.id == todo.id }?.description = todo.description
    }

    private companion object {
        var TODOS = mutableListOf(
            Todo(1, "Milo", "The first one", LocalDate.now().plusYears(1), false),
            Todo(2, "Sorrento", "Poseidon", LocalDate.now().plusYears(2), false),
            Todo(3, "Yoga", "Bronze Saint", LocalDate.now().plusYears(3), false)
        )
    }
}
