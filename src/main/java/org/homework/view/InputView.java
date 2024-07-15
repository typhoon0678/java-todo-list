package org.homework.view;

import org.homework.dto.AddTodoInput;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    // todoMethod

    public AddTodoInput addTodo() throws IllegalArgumentException {
        System.out.print("할 일을 입력해주세요 >> ");
        String content = scanner.nextLine();

        System.out.print("마감일을 입력해주세요 (ex 240101) >> ");
        String dateStr = scanner.nextLine();

        return new AddTodoInput(content, dateStr);
    }

    public int deleteTodo() throws IllegalArgumentException {
        System.out.print("삭제하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getTodo() throws IllegalArgumentException {
        System.out.print("조회하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int updateTodo() throws IllegalArgumentException {
        System.out.print("수정하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    // menuMethod

    public String selectMenu() {
        System.out.print("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 7일 이냬 조회, 5. 검색, 6, 수정, 7. 종료 >> ");
        return scanner.nextLine();
    }

    public String writeSearchKeyword() {
        System.out.print("검색어를 입력해주세요 >> ");
        return scanner.nextLine();
    }
}
