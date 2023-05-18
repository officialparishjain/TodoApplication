package com.parishjain.TodoApplication.controller;

import com.parishjain.TodoApplication.model.Todo;
import com.parishjain.TodoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService ;


    // Get all todos in the list
    @GetMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodosInMyList();
    }

    @GetMapping(value = "/getAllTodoByStatus")
    public List<Todo> getAllTodoByStatus(@RequestParam String status){

        return todoService.getAllTodoByUserStatus(status);
    }

    // add to do
    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.addMyTodo(todo);
    }

    // get the specific Todo
    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return  todoService.getTodoBasedOnId(id);
    }

    // Create a delete endpoint
    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteByItsId(@PathVariable String id){
        return todoService.deleteTodoById(id);
    }


    // Update Todo
    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);
    }
}
