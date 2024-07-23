package org.homework.service;

import org.homework.domain.Todo;
import org.homework.dto.AddTodoInput;
import org.homework.dto.UpdateTodoOutput;
import org.homework.repository.TodoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public int addTodo(AddTodoInput addTodoInput) {
        String content = addTodoInput.getContent();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate endDate = LocalDate.parse(addTodoInput.getDateStr(), formatter);

        return todoRepository.addTodo(content, endDate);
    }

    public void deleteTodo(int todoId) {
        todoRepository.deleteTodo(todoId)
                .orElseThrow(NoSuchElementException::new);
    }

    public Todo getTodo(int todoId) {
        return todoRepository.getTodo(todoId)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Todo> getWeekTodo() {
        return todoRepository.getWeekTodoList();
    }

    public List<Todo> getSearchTodo(String keyword) {
        return todoRepository.getSearchTodoList(keyword);
    }

    public UpdateTodoOutput updateTodo(Todo todo) {
        boolean isUpdated = todoRepository.updateTodoComplete(todo.getId());
        if (isUpdated) todo.complete();

        return new UpdateTodoOutput(todo, isUpdated);
    }
}
