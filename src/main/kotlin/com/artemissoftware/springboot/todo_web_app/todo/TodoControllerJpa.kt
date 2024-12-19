package com.artemissoftware.springboot.todo_web_app.todo

import jakarta.validation.Valid
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.SessionAttributes
import java.time.LocalDate

@Controller
@SessionAttributes("name")
class TodoControllerJpa(
    private val todoRepository: TodoRepository
) {

    @RequestMapping("list-todos")
    fun listAllTodos(model: ModelMap): String{
        println("User: " + getLoggedUsername())
        println("list: " + todoRepository.findByUsername(getLoggedUsername()))
        model.addAttribute("todos", todoRepository.findByUsername(getLoggedUsername()))
        return "listTodos"
    }

    @RequestMapping(value = ["add-todo"], method = [RequestMethod.GET])
    fun showNewTodoPage(model: ModelMap): String{
        val todo = Todo(10, getLoggedUsername(), "", LocalDate.now().plusYears(1), false)
        model["todo"] = todo
        return "todo"
    }

    @RequestMapping(value = ["add-todo"], method = [RequestMethod.POST])
    fun addNewTodo(model: ModelMap, @Valid todo: Todo, result: BindingResult): String{
        if(result.hasErrors()){
            return "todo"
        }
        todo.username = getLoggedUsername()
        todoRepository.save(todo)

        return "redirect:list-todos"
    }

    @RequestMapping("delete-todo")
    fun deleteTodo(@RequestParam id:Int): String{
        todoRepository.deleteById(id)
        return "redirect:list-todos"
    }

    @RequestMapping(value = ["update-todo"], method = [RequestMethod.GET])
    fun showUpdateTodoPage(@RequestParam id: Int, model: ModelMap): String {
        todoRepository.findById(id).get().let { todo ->
            model.addAttribute("todo", todo)
        }

        return "todo"
    }

    @RequestMapping(value = ["update-todo"], method = [RequestMethod.POST])
    fun updateTodo(model: ModelMap, todo: @Valid Todo, result: BindingResult): String {
        if (result.hasErrors()) {
            return "todo"
        }

        todo.username = getLoggedUsername()
        todoRepository.save(todo)
        return "redirect:list-todos"
    }

    private fun getLoggedUsername(): String {
        val authentication = SecurityContextHolder.getContext().authentication
        return authentication.name
    }
}