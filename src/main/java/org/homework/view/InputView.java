package org.homework.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    // todoMethod

    public String addTodo() {
        System.out.print("할 일을 입력해주세요 >> ");
        return scanner.nextLine();
    }

    public int deleteTodo() {
        System.out.print("삭제하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        int todoId = scanner.nextInt();
        scanner.nextLine();
        return todoId;
    }

    public int getTodo() {
        System.out.print("조회하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        int todoId = scanner.nextInt();
        scanner.nextLine();
        return todoId;
    }

    public int updateTodo() {
        System.out.print("수정하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        int todoId = scanner.nextInt();
        scanner.nextLine();
        return todoId;
    }

    // menuMethod

    public String selectMenu() {
        System.out.print("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4, 수정, 5. 종료 >> ");
        return scanner.nextLine();
    }
}
