package com.parishjain.TodoApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


public class Todo{

    private String id;

    @JsonProperty("todoname")
    private String todoName;
    private Boolean todoStatus;

    public Todo(String id, String todoName  , Boolean todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
