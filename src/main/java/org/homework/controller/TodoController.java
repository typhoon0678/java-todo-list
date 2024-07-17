package org.homework.controller;

import org.homework.domain.InputMenu;
import org.homework.domain.Todo;
import org.homework.dto.AddTodoInput;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.OutputView;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;

public class TodoController {

    private final TodoService todoService = new TodoService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Todo todo;
    private int todoId;

    public void run() {

        InputMenu menu;

        do {
            String menuValue = inputView.selectMenu();
            menu = InputMenu.getInputMenu(menuValue);

            try {
                switch (menu) {
                    case ADD:
                        addTodo();
                        break;
                    case DELETE:
                        deleteTodo();
                        break;
                    case VIEW:
                        viewTodo();
                        break;
                    case WEEK_VIEW:
                        weekViewTodo();
                        break;
                    case SEARCH:
                        searchTodo();
                        break;
                    case UPDATE:
                        updateTodo();
                        break;
                    case EXIT:
                        outputView.exit();
                        break;
                    case OTHERWISE:
                        outputView.invalidInput();
                }

            } catch (NoSuchElementException e) {
                outputView.getEmptyTodo();
            } catch (IllegalArgumentException e) {
                outputView.invalidInput();
            } catch (DateTimeParseException e) {
                outputView.invalidDateInput();
            }

        } while (!InputMenu.isExit(menu));

    }

    private void addTodo() {
        AddTodoInput addTodoInput = inputView.addTodo();

        todoId = todoService.addTodo(addTodoInput);

        outputView.addTodo(todoId);
    }

    private void deleteTodo() {
        todoId = inputView.deleteTodo();

        todoService.deleteTodo(todoId);

        outputView.deleteTodo(todoId);
    }

    private void viewTodo() {
        todoId = inputView.getTodo();

        todo = todoService.getTodo(todoId);

        outputView.getTodo(todo);
    }

    private void weekViewTodo() {
        List<Todo> weekTodoList = todoService.getWeekTodo();

        if (!weekTodoList.isEmpty()) {
            outputView.weekTodoInfo(weekTodoList);
        } else {
            outputView.getEmptyWeekTodo();
        }
    }

    private void searchTodo() {
        String keyword = inputView.writeSearchKeyword();

        List<Todo> searchTodoList = todoService.getSearchTodo(keyword);

        if (!searchTodoList.isEmpty()) {
            outputView.searchTodoInfo(searchTodoList);
        } else {
            outputView.getEmptySearchTodo();
        }
    }

    private void updateTodo() {
        todoId = inputView.updateTodo();

        todo = todoService.getTodo(todoId);
        boolean isUpdated = todoService.updateTodo(todo);

        if (isUpdated) {
            outputView.updateCompleteTrue(todo);
        } else {
            outputView.keepCompleteTrue(todo);
        }
    }
}
