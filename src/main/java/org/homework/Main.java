package org.homework;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.homework.controller.TodoController;
import org.homework.repository.MapTodoRepository;
import org.homework.repository.MySQLTodoRepository;
import org.homework.repository.TodoRepository;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // Local
//        TodoRepository todoRepository = new MapTodoRepository();

        // MySQL
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("java-todo-list");
        TodoRepository todoRepository = new MySQLTodoRepository(entityManagerFactory);

        TodoService todoService = new TodoService(todoRepository);

        TodoController todoController =
                new TodoController(todoService, inputView, outputView);

        todoController.run();
    }
}