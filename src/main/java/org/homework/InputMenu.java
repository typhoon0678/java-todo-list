package org.homework;

import java.util.Arrays;

public enum InputMenu {
    ADD("1"),
    DELETE("2"),
    VIEW("3"),
    EXIT("4"),
    OTHERWISE("");

    private final String input;

    InputMenu(String input) {
        this.input = input;
    }

    public static InputMenu getInputMenu(String input) {

        return Arrays.stream(values())
                .filter(inputMenu -> inputMenu.input.equals(input))
                .findAny()
                .orElse(OTHERWISE);
    }
}
