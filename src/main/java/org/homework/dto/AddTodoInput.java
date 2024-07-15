package org.homework.dto;

public class AddTodoInput {

    private final String content;
    private final String dateStr;

    public AddTodoInput(String content, String dateStr) {
        this.content = content;
        this.dateStr = dateStr;
    }

    public String getContent() {
        return content;
    }

    public String getDateStr() {
        return dateStr;
    }
}
