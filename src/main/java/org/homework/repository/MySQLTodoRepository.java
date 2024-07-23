package org.homework.repository;

import org.apache.ibatis.session.SqlSession;
import org.homework.domain.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MySQLTodoRepository implements TodoRepository {

    private final SqlSession sqlSession;

    public MySQLTodoRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int addTodo(String content, LocalDate endDate) {
        Todo todo = new Todo(content, endDate);

        sqlSession.insert("addTodo", todo);
        return todo.getId();
    }

    @Override
    public Optional<Todo> getTodo(int todoId) {
        return Optional.ofNullable(
                sqlSession.selectOne("getTodoById", todoId));
    }

    @Override
    public List<Todo> getWeekTodoList() {
        return sqlSession.selectList("getWeekTodoList");
    }

    @Override
    public List<Todo> getSearchTodoList(String keyword) {
        return sqlSession.selectList("getSearchTodoList", keyword);
    }

    @Override
    public boolean updateTodoComplete(int todoId) {
        return sqlSession.update("completeTodoById", todoId) > 0;
    }

    @Override
    public Optional<Todo> deleteTodo(int todoId) {
        boolean result = sqlSession.delete("deleteTodoById", todoId) > 0;

        return (result) ? Optional.of(new Todo(todoId)) : Optional.empty();
    }
}
