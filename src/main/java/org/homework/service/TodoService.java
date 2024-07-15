package org.homework.service;

import org.homework.domain.Todo;
import org.homework.dto.AddTodoInput;
import org.homework.repository.TodoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

public class TodoService {

    public int addTodo(AddTodoInput addTodoInput) {
        String content = addTodoInput.getContent();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate endDate = LocalDate.parse(addTodoInput.getDateStr(), formatter);

        return TodoRepository.addTodo(content, endDate);
    }

    public boolean deleteTodo(int todoId) {
        return TodoRepository.deleteTodo(todoId).isPresent();
    }

    public Todo getTodo(int todoId) {
        return TodoRepository.getTodo(todoId)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Todo> getWeekTodo() {
        return TodoRepository.getWeekTodoList();
    }

    public List<Todo> getSearchTodo(String keyword) {
        return TodoRepository.getSearchTodoList(keyword);
    }

    public boolean updateTodo(Todo todo) {
        if (!todo.isCompleted()) {
            TodoRepository.updateTodoComplete(todo.getId());
            return true;
        }

        return false;
    }
}
