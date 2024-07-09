package org.homework.repository;

import org.homework.domain.Todo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TodoRepository {

    private static int seq = 0;
    private static final Map<Integer, Todo> todoMap = new HashMap<>();

    public static boolean containsTodo(int todoId) {
        return todoMap.containsKey(todoId);
    }

    public static int addTodo(String content) {
        Todo todo = new Todo(++seq, content);

        todoMap.put(todo.getId(), todo);
        return todo.getId();
    }

    public static Todo getTodo(int todoId) {
        if (todoMap.containsKey(todoId)) {
            return todoMap.get(todoId);
        }

        return null;
    }

    public static void updateTodoComplete(int todoId) {
        Todo todo = todoMap.get(todoId);

        todo.setCompleted(true);
        todoMap.put(todoId, todo);
    }

    public static boolean deleteTodo(int todoId) {
        return todoMap.remove(todoId) != null;
    }
}
