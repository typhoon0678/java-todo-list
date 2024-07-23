package org.homework.repository;


import jakarta.persistence.*;
import org.homework.domain.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MySQLTodoRepository implements TodoRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final EntityTransaction transaction;

    public MySQLTodoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    @Override
    public int addTodo(String content, LocalDate endDate) {
        Todo todo = new Todo(content, endDate);

        transaction.begin();
        entityManager.persist(todo);
        transaction.commit();

        return todo.getId();
    }

    @Override
    public Optional<Todo> getTodo(int todoId) {
        return Optional.ofNullable(entityManager.find(Todo.class, todoId));
    }

    @Override
    public List<Todo> getWeekTodoList() {
        return entityManager.createQuery(
                        "SELECT t FROM Todo t " +
                                "WHERE DATEDIFF(t.deadline, CURRENT_DATE()) " +
                                "BETWEEN 0 AND 7",
                        Todo.class)
                .getResultList();
    }

    @Override
    public List<Todo> getSearchTodoList(String keyword) {
        return entityManager.createQuery(
                        "SELECT t FROM Todo t " +
                                "WHERE t.content LIKE " +
                                "CONCAT('%', :keyword, '%')",
                        Todo.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    @Override
    public void updateTodoComplete(int todoId) {
        entityManager.find(Todo.class, todoId).complete();
    }

    @Override
    public Optional<Todo> deleteTodo(int todoId) {
        Optional<Todo> todo = getTodo(todoId);

        if (todo.isPresent()) {
            transaction.begin();
            entityManager.remove(todo.get());
            transaction.commit();
        }

        return todo;
    }
}
