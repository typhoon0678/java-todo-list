package org.homework.controller;

import org.homework.domain.InputMenu;
import org.homework.service.TodoService;

public class TodoController {

    private final TodoService todoService = new TodoService();

    InputMenu menu;

    public void run() {

        do {
            menu = todoService.selectMenu();

            switch (menu) {
                case ADD:
                    todoService.addTodo();
                    break;
                case DELETE:
                    todoService.deleteTodo();
                    break;
                case VIEW:
                    todoService.viewTodo();
                    break;
                case UPDATE:
                    todoService.updateTodo();
                    break;
                case EXIT:
                    todoService.exitMenu();
                    break;
                case OTHERWISE:
                    todoService.invalidInputMenu();
            }

        } while (!InputMenu.isExit(menu));

    }
}
