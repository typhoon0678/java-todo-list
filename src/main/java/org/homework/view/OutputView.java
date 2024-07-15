package org.homework.view;

import org.homework.domain.Todo;

import java.util.List;

public class OutputView {

    // todoMethod

    public void addTodo(int todoId) {
        System.out.printf("할 일이 추가되었습니다. ID: %d\n\n", todoId);
    }

    public void deleteTodo(int todoId) {
        System.out.printf("할 일이 삭제되었습니다. ID: %d\n\n", todoId);
    }

    public void getTodo(Todo todo) {
        todoInfo(todo);
    }

    public void updateCompleteTrue(Todo todo) {
        System.out.println("할 일을 완료 상태로 변경하였습니다.");
        todoInfo(todo);
    }

    public void keepCompleteTrue(Todo todo) {
        System.out.println("할 일이 이미 완료 상태입니다.");
        todoInfo(todo);
    }

    public void weekTodoInfo(List<Todo> weekTodoList) {
        todoInfoTitle();
        weekTodoList.forEach(System.out::print);
        System.out.println();
    }

    public void searchTodoInfo(List<Todo> searchTodoList) {
        todoInfoTitle();
        searchTodoList.forEach(System.out::print);
        System.out.println();
    }

    public void getEmptyTodo() {
        System.out.println("해당 ID의 할 일이 없습니다.\n");
    }

    public void getEmptyWeekTodo() {
        System.out.println("7일 이내 할 일이 없습니다.\n");
    }

    public void getEmptySearchTodo() {
        System.out.println("검색 결과가 없습니다.\n");
    }

    private void todoInfoTitle() {
        System.out.printf(Todo.TODO_FORMAT, "ID", "내용", "상태", "마감일");
        System.out.println("--------------------------------------------------");
    }

    private void todoInfo(Todo todo) {
        todoInfoTitle();
        System.out.println(todo);
    }

    // menuMethod

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void invalidInput() {
        System.out.println("잘못된 입력입니다.\n");
    }
}
