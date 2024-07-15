package org.homework.domain;

import java.util.Arrays;

public enum InputMenu {
    ADD("1"),
    DELETE("2"),
    VIEW("3"),
    WEEK_VIEW("4"),
    SEARCH("5"),
    UPDATE("6"),
    EXIT("7"),
    OTHERWISE("");

    private final String input;

    InputMenu(String input) {
        this.input = input;
    }

    public static boolean isExit(InputMenu menu) {
        return menu.equals(EXIT);
    }

    public static InputMenu getInputMenu(String input) {

        return Arrays.stream(values())
                .filter(inputMenu -> inputMenu.input.equals(input))
                .findAny()
                .orElse(OTHERWISE);
    }
}
