package com.artemissoftware.springboot.todo_web_app.todo

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.SessionAttributes
import java.time.LocalDate

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
    fun addNewTodo(@RequestParam description: String, model: ModelMap): String{
        todoService.addTodo(
            username = model.get("name").toString(),
            description = description,
            LocalDate.now().plusYears(1),
            false
        )
        return "redirect:list-todos"
    }
}