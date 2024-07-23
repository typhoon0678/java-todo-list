package org.homework;

import org.apache.ibatis.session.SqlSession;
import org.homework.controller.TodoController;
import org.homework.mybatis.MybatisConnectionFactory;
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

        // Map
        TodoRepository todoRepository = new MapTodoRepository();
        // MySQL
//        SqlSession session = MybatisConnectionFactory.getSqlSession();
//        TodoRepository todoRepository = new MySQLTodoRepository(session);

        TodoService todoService = new TodoService(todoRepository);

        TodoController todoController = new TodoController(
                todoService,
                inputView,
                outputView
        );

        todoController.run();
    }
}