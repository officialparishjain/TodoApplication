package com.parishjain.TodoApplication.service;

import com.parishjain.TodoApplication.model.Todo;
import com.parishjain.TodoApplication.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;


    public List<Todo> getAllTodosInMyList() {

        return  todoRepository.getAllTodos();
    }

    public String addMyTodo(Todo todo) {
        boolean insertionStatus = todoRepository.save(todo);
        if(insertionStatus) return "Your Todo has added";
        else return "Not Added";
    }


    public Todo getTodoBasedOnId(String id) {

        List<Todo> getAllTodoRightNow = todoRepository.getAllTodos();

        for(Todo todo : getAllTodoRightNow){
            if(todo.getId().equals(id)) return todo;
        }
        return null;
    }


    public String deleteTodoById(String id) {
        List<Todo> getAllTodoRightNow = todoRepository.getAllTodos();
        if(id != null)
        {
            for(Todo todo : getAllTodoRightNow){
                if(todo.getId().equals(id)) {
                    boolean status = todoRepository.remove(todo);
                    if(status) return "Deleted";
                }
            }
            return "Id not found";
        }
        return null;
    }

    public String updateTodoStatusById(String id,String status) {

        boolean updateStatus = todoRepository.updateTodo(id,Boolean.parseBoolean(status));
        if(updateStatus) return "Updated";
        else return "Not Updated";

    }

    public List<Todo> getAllTodoByUserStatus(String status) {

        List<Todo> getAllTodoRightNow = todoRepository.getAllTodos();
        List<Todo> listBasedOnStatus = new ArrayList<>();
        for(Todo todo : getAllTodoRightNow){
            if(todo.getTodoStatus() == Boolean.parseBoolean(status)){
                listBasedOnStatus.add(todo);
            }
        }
        return listBasedOnStatus;
    }
}
