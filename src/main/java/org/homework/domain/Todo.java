package org.homework.domain;

import java.time.LocalDate;

public class Todo {

    private final int id;
    private final String content;
    private final LocalDate deadline;
    private boolean completed;

    public static final String TODO_FORMAT = "%-4s%-20s%-10s%-15s\n";

    public Todo(int id, String content, LocalDate deadline) {
        this.id = id;
        this.content = content;
        this.deadline = deadline;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCompletedStr() {
        return completed ? "완료" : "미완료";
    }

    public void setCompletedTrue() {
        this.completed = true;
    }

    public String toString() {
        return String.format(TODO_FORMAT, id, content, getCompletedStr(), deadline);
    }

    public boolean isContainKeyword(String keyword) {
        String contentLower = content.toLowerCase();
        String keywordLower = keyword.toLowerCase();

        return contentLower.contains(keywordLower);
    }
}
