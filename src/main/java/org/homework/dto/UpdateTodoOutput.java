package org.homework.dto;

import org.homework.domain.Todo;

public class UpdateTodoOutput {

    Todo todo;
    boolean isUpdated;

    public UpdateTodoOutput(Todo todo, boolean isUpdated) {
        this.todo = todo;
        this.isUpdated = isUpdated;
    }

    public Todo getTodo() {
        return todo;
    }

    public boolean isUpdated() {
        return isUpdated;
    }
}
