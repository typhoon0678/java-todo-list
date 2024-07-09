package org.homework.view;

import org.homework.domain.Todo;

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

    public void todoInfo(Todo todo) {
        String completeStatus = (todo.isCompleted()) ? "완료" : "미완료";

        System.out.printf("할 일 ID: %d 내용: %s 상태: %s\n\n",
                todo.getId(), todo.getContent(), completeStatus);
    }

    public void getNullTodo() {
        System.out.println("해당 ID의 할 일이 없습니다.\n");
    }

    // menuMethod

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void invalidInput() {
        System.out.println("잘못된 입력입니다.\n");
    }
}
