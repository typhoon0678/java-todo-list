package org.homework.repository;

import org.homework.domain.Todo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class TodoRepository {

    private static int seq = 0;
    private static final Map<Integer, Todo> todoMap = new HashMap<>();

    public static int addTodo(String content, LocalDate endDate) {
        Todo todo = new Todo(++seq, content, endDate);

        todoMap.put(todo.getId(), todo);
        return todo.getId();
    }

    public static Optional<Todo> getTodo(int todoId) {
        return Optional.ofNullable(todoMap.get(todoId));
    }

    public static List<Todo> getWeekTodoList() {
        LocalDate today = LocalDate.now();

        return new ArrayList<>(todoMap.values()).stream()
                .filter(todo -> {
                    long betweenDays = today.until(todo.getDeadline(), ChronoUnit.DAYS);
                    return betweenDays >= 0 && betweenDays <= 7;
                })
                .sorted(Comparator.comparing(Todo::getDeadline))
                .collect(Collectors.toList());
    }

    public static List<Todo> getSearchTodoList(String keyword) {
        return new ArrayList<>(todoMap.values()).stream()
                .filter(todo -> {
                    String contentLower = todo.getContent().toLowerCase();
                    String keywordLower = keyword.toLowerCase();
                    return contentLower.contains(keywordLower);
                })
                .sorted(Comparator.comparing(Todo::getDeadline))
                .collect(Collectors.toList());
    }


    public static void updateTodoComplete(int todoId) {
        Todo todo = todoMap.get(todoId);

        todo.setCompleted(true);
        todoMap.put(todoId, todo);
    }

    public static Optional<Todo> deleteTodo(int todoId) {
        return Optional.ofNullable(todoMap.remove(todoId));
    }
}
