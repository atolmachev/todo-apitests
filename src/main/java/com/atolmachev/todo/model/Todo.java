package com.atolmachev.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Boolean completed;
    private Integer rank;

    public Todo() {}

    public Todo(String title, Boolean completed, Integer rank) {
        this(0, title, completed, rank);
    }

    public Todo(int id, String title, Boolean completed, Integer rank) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return nonNull(completed,false);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getRank() {
        return nonNull(rank, 0);
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Todo merge(Todo newTodo) {
        return new Todo(id,
                nonNull(newTodo.title, title),
                nonNull(newTodo.completed, completed),
                nonNull(newTodo.rank, rank));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", rank=" + rank +
                '}';
    }
}
