package org.homework.domain;

import java.time.LocalDate;

public class Todo {

    private int id;
    private String content;
    private LocalDate deadline;
    private boolean completed;

    public static final String TODO_FORMAT = "%-4s%-20s%-10s%-15s\n";

    public Todo(int id, String content, LocalDate deadline, boolean completed) {
        this.id = id;
        this.content = content;
        this.deadline = deadline;
        this.completed = completed;
    }

    public Todo(int id, String content, LocalDate deadline) {
        this.id = id;
        this.content = content;
        this.deadline = deadline;
        this.completed = false;
    }

    public Todo(String content, LocalDate deadline) {
        this.content = content;
        this.deadline = deadline;
    }

    public Todo(int id) {
        this.id = id;
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

    public void complete() {
        this.completed = true;
    }

    public String toString() {
        return String.format(TODO_FORMAT, id, content, getCompletedStr(), deadline);
    }

    public boolean contains(String keyword) {
        String contentLower = content.toLowerCase();
        String keywordLower = keyword.toLowerCase();

        return contentLower.contains(keywordLower);
    }
}
