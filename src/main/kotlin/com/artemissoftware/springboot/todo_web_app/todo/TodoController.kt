package com.artemissoftware.springboot.todo_web_app.todo

import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
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
    fun showNewTodoPage(model: ModelMap): String{
        val todo = Todo(10, model["name"].toString(), "", LocalDate.now().plusYears(1), false)
        model["todo"] = todo
        return "todo"
    }

    @RequestMapping(value = ["add-todo"], method = [RequestMethod.POST])
    fun addNewTodo(model: ModelMap, @Valid todo: Todo, result: BindingResult): String{
        println("result = ${result.model.toString()}  ")
        println("result = ${result.hasErrors()}  ")
        if(result.hasErrors()){
            return "todo"
        }
        todoService.addTodo(
            username = model["name"].toString(),
            description = todo.description,
            LocalDate.now().plusYears(1),
            false
        )
        return "redirect:list-todos"
    }

    @RequestMapping("delete-todo")
    fun deleteTodo(@RequestParam id:Int): String{
        todoService.deleteById(id)
        return "redirect:list-todos"
    }
}