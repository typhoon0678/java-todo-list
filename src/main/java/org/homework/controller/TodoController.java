package org.homework.controller;

import org.homework.domain.InputMenu;
import org.homework.domain.Todo;
import org.homework.dto.AddTodoInput;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.OutputView;

import java.util.List;

public class TodoController {

    private final TodoService todoService = new TodoService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    InputMenu menu;
    int todoId;
    Todo todo;
    AddTodoInput addTodoInput;
    String keyword;

    public void run() {

        do {
            String menuValue = inputView.selectMenu();
            menu = InputMenu.getInputMenu(menuValue);

            switch (menu) {
                case ADD:
                    addTodoInput = inputView.addTodo();

                    try {
                        todoId = todoService.addTodo(addTodoInput);
                    } catch (Exception e) {
                        outputView.invalidInput();
                        break;
                    }

                    outputView.addTodo(todoId);
                    break;

                case DELETE:
                    try {
                        todoId = inputView.deleteTodo();
                    } catch (Exception e) {
                        outputView.invalidInput();
                        break;
                    }

                    boolean isDeleted = todoService.deleteTodo(todoId);

                    if (isDeleted) {
                        outputView.deleteTodo(todoId);
                    } else {
                        outputView.getEmptyTodo();
                    }
                    break;

                case VIEW:
                    try {
                        todoId = inputView.getTodo();
                    } catch (Exception e) {
                        outputView.invalidInput();
                        break;
                    }

                    try {
                        todo = todoService.getTodo(todoId);
                    } catch (Exception e) {
                        outputView.getEmptyTodo();
                        break;
                    }

                    outputView.getTodo(todo);
                    break;

                case WEEK_VIEW:
                    List<Todo> weekTodoList = todoService.getWeekTodo();

                    if (!weekTodoList.isEmpty()) {
                        outputView.weekTodoInfo(weekTodoList);
                    } else {
                        outputView.getEmptyWeekTodo();
                    }
                    break;

                case SEARCH:
                    keyword = inputView.writeSearchKeyword();
                    List<Todo> searchTodoList = todoService.getSearchTodo(keyword);

                    if (!searchTodoList.isEmpty()) {
                        outputView.searchTodoInfo(searchTodoList);
                    } else {
                        outputView.getEmptySearchTodo();
                    }
                    break;

                case UPDATE:
                    try {
                        todoId = inputView.updateTodo();
                    } catch (Exception e) {
                        outputView.invalidInput();
                        break;
                    }

                    try {
                        todo = todoService.getTodo(todoId);
                    } catch (Exception e) {
                        outputView.getEmptyTodo();
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
