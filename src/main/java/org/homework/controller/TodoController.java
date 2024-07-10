package org.homework.controller;

import org.homework.domain.InputMenu;
import org.homework.domain.Todo;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class TodoController {

    private final TodoService todoService = new TodoService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    InputMenu menu;
    int todoId;
    Todo todo;

    public void run() {

        do {
            String menuValue = inputView.selectMenu();
            menu = InputMenu.getInputMenu(menuValue);

            switch (menu) {
                case ADD:
                    String content = inputView.addTodo();
                    todoId = todoService.addTodo(content);

                    outputView.addTodo(todoId);
                    break;

                case DELETE:
                    todoId = inputView.deleteTodo();
                    boolean isDeleted = todoService.deleteTodo(todoId);

                    if (isDeleted) {
                        outputView.deleteTodo(todoId);
                    } else {
                        outputView.getNullTodo();
                    }
                    break;

                case VIEW:
                    todoId = inputView.getTodo();
                    todo = todoService.getTodo(todoId);

                    if (todo != null) {
                        outputView.getTodo(todo);
                    } else {
                        outputView.getNullTodo();
                    }
                    break;

                case UPDATE:
                    todoId = inputView.updateTodo();
                    todo = todoService.getTodo(todoId);

                    if (todo == null) {
                        outputView.getNullTodo();
                        break;
                    }

                    boolean isUpdated = todoService.updateTodo(todo);
                    if (isUpdated) {
                        outputView.updateCompleteTrue(todo);
                    } else {
                        outputView.keepCompleteTrue(todo);
                    }
                    break;

                case EXIT:
                    outputView.exit();
                    break;

                case OTHERWISE:
                    outputView.invalidInput();
            }

        } while (!InputMenu.isExit(menu));

    }
}
