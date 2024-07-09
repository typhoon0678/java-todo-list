package org.homework.service;

import org.homework.domain.InputMenu;
import org.homework.domain.Todo;
import org.homework.repository.TodoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class TodoService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    // todoMethod

    public void addTodo() {
        String content = inputView.addTodo();
        int todoId = TodoRepository.addTodo(content);
        outputView.addTodo(todoId);
    }

    public void deleteTodo() {
        int todoId = inputView.deleteTodo();
        boolean isDeleted = TodoRepository.deleteTodo(todoId);

        if (isDeleted) {
            outputView.deleteTodo(todoId);
        } else {
            outputView.getNullTodo();
        }
    }

    public void viewTodo() {
        int todoId = inputView.getTodo();

        if (TodoRepository.containsTodo(todoId)) {
            Todo todo = TodoRepository.getTodo(todoId);
            outputView.getTodo(todo);
        } else {
            outputView.getNullTodo();
        }
    }

    public void updateTodo() {
        int todoId = inputView.updateTodo();

        if (TodoRepository.containsTodo(todoId)) {
            Todo todo = TodoRepository.getTodo(todoId);
            TodoRepository.updateTodoComplete(todoId);
            outputView.updateCompleteTrue(todo);
        } else {
            outputView.getNullTodo();
        }
    }

    // menuMethod

    public InputMenu selectMenu() {
        String menuValue = inputView.selectMenu();
        return InputMenu.getInputMenu(menuValue);
    }

    public void exitMenu() {
        outputView.exit();
    }

    public void invalidInputMenu() {
        outputView.invalidInput();
    }
}
