package org.homework.repository;

import org.homework.domain.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    int addTodo(String content, LocalDate endDate);

    Optional<Todo> getTodo(int todoId);

    List<Todo> getWeekTodoList();

    List<Todo> getSearchTodoList(String keyword);

    boolean updateTodoComplete(int todoId);

    Optional<Todo> deleteTodo(int todoId);
}
