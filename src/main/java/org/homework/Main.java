package org.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        InputMenu inputMenu = InputMenu.getInputMenu(input);

        System.out.println(inputMenu);

    }
}