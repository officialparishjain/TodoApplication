package com.parishjain.TodoApplication.repository;

import com.parishjain.TodoApplication.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {

    private List<Todo> todoList ;


    public TodoRepository(){
        todoList = new ArrayList<>();
        todoList.add(new Todo("0","Testing the Todo Service Application",true));
    }

    public boolean save(Todo todo) {
        todoList.add(todo);
        return true;
    }

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public boolean remove(Todo todo){
        todoList.remove(todo);
        return true;
    }

    public boolean updateTodo(String id,boolean status) {
        for(Todo todo : todoList){
            if(todo.getId().equals(id)) {

                // Remove todo
                remove(todo);

                //Change this todo now
                todo.setTodoStatus(status);

                // Add this new todo
                save(todo);

                return true;
            }
        }
        return false;
    }
}
