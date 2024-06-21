package ru.kuyamaks.projects.library.models;

import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    private int readerId;

    @NotEmpty(message = "Book title should not be empty")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    public Book() {
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(int id, int readerId, String title, String author) {
        this.id = id;
        this.readerId = readerId;
        this.title = title;
        this.author = author;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
