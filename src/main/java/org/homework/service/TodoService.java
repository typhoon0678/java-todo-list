package org.homework.service;

import org.homework.domain.Todo;
import org.homework.repository.TodoRepository;

public class TodoService {

    public int addTodo(String content) {
        return TodoRepository.addTodo(content);
    }

    public boolean deleteTodo(int todoId) {
        return TodoRepository.deleteTodo(todoId);
    }

    public Todo getTodo(int todoId) {
        if (TodoRepository.containsTodo(todoId)) {
            return TodoRepository.getTodo(todoId);
        }

        return null;
    }

    public boolean updateTodo(Todo todo) {
        if (!todo.isCompleted()) {
            TodoRepository.updateTodoComplete(todo.getId());
            return true;
        }

        return false;
    }
}
