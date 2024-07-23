package org.homework.repository;

import org.homework.domain.Todo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MapTodoRepository implements TodoRepository {

    private static int seq = 0;
    private static final Map<Integer, Todo> todoMap = new HashMap<>();

    public int addTodo(String content, LocalDate endDate) {
        Todo todo = new Todo(++seq, content, endDate);

        todoMap.put(todo.getId(), todo);
        return todo.getId();
    }

    public Optional<Todo> getTodo(int todoId) {
        return Optional.ofNullable(todoMap.get(todoId));
    }

    public List<Todo> getWeekTodoList() {
        LocalDate today = LocalDate.now();

        return todoMap.values().stream()
                .filter(todo -> {
                    long betweenDays = today.until(todo.getDeadline(), ChronoUnit.DAYS);
                    return betweenDays >= 0 && betweenDays <= 7;
                })
                .sorted(Comparator.comparing(Todo::getDeadline))
                .collect(Collectors.toList());
    }

    public List<Todo> getSearchTodoList(String keyword) {
        return todoMap.values().stream()
                .filter(todo -> todo.contains(keyword))
                .sorted(Comparator.comparing(Todo::getDeadline))
                .collect(Collectors.toList());
    }


    public void updateTodoComplete(int todoId) {
        Todo todo = todoMap.get(todoId);

        todo.complete();
        todoMap.put(todoId, todo);
    }

    public Optional<Todo> deleteTodo(int todoId) {
        return Optional.ofNullable(todoMap.remove(todoId));
    }
}
