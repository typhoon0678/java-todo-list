package org.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int todoId;
        InputMenu inputMenu = null;

        while (inputMenu != InputMenu.EXIT) {
            System.out.print("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료 >> ");
            input = scanner.nextLine();

            inputMenu = InputMenu.getInputMenu(input);
            switch (inputMenu) {

                case ADD:
                    System.out.print("할 일을 입력해주세요 >> ");
                    String todoInput = scanner.nextLine();

                    Data.todoMap.put(++Data.seq, todoInput);
                    System.out.printf("할 일이 추가되었습니다. ID: %d\n\n", Data.seq);
                    break;

                case DELETE:
                    System.out.print("삭제하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
                    todoId = scanner.nextInt();
                    scanner.nextLine();

                    String removeTodo = Data.todoMap.remove(todoId);

                    if (removeTodo != null) {
                        System.out.printf("할 일이 삭제되었습니다. ID: %d\n\n", todoId);
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.\n");
                    }

                    break;

                case VIEW:
                    System.out.print("조회하고 싶은 할 일의 고유 번호(ID)를 입력해주세요 >> ");
                    todoId = scanner.nextInt();
                    scanner.nextLine();

                    String getTodo = Data.todoMap.get(todoId);

                    if (getTodo != null) {
                        System.out.printf("할 일 ID: %d 내용: %s\n\n", todoId, getTodo);
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.\n");
                    }

                    break;

                case EXIT:
                    System.out.println("프로그램을 종료합니다. ");
                    break;

                case OTHERWISE:
                    System.out.println("잘못된 입력입니다.\n");
                    break;
            }
        }

    }
}