package com.artemissoftware.springboot.todo_web_app.todo

import org.springframework.data.jpa.repository.JpaRepository


interface TodoRepository : JpaRepository<Todo, Int> {
    fun findByUsername(username: String): List<Todo>
}