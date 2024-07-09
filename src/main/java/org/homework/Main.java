package org.homework;

import org.homework.controller.TodoController;

public class Main {
    public static void main(String[] args) {
        TodoController todoController = new TodoController();

        todoController.run();
    }
}