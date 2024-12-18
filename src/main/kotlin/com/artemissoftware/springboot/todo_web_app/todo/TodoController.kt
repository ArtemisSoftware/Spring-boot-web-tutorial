package com.artemissoftware.springboot.todo_web_app.todo

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.SessionAttributes

@Controller
@SessionAttributes("name")
class TodoController(
    private val todoService: TodoService
) {

    @RequestMapping("list-todos")
    fun listAllTodos(model: ModelMap): String{
        model.addAttribute("todos", todoService.findByUsername("Yoga"))
        return "listTodos"
    }

    @RequestMapping(value = ["add-todo"], method = [RequestMethod.GET])
    fun showNewTodoPage(): String{
        return "todo"
    }

    @RequestMapping(value = ["add-todo"], method = [RequestMethod.POST])
    fun addNewTodo(): String{
        return "redirect:list-todos"
    }
}