package org.homework.domain;

public class Todo {

    private final int id;
    private String content;
    private boolean completed;

    public Todo(int id, String content) {
        this.id = id;
        this.content = content;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
