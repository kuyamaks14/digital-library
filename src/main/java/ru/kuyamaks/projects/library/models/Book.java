package ru.kuyamaks.projects.library.models;

import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    private int readerId;

    @NotEmpty(message = "Book title should not be empty")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @NotEmpty(message = "Publication year should not be empty")
    private String publicationYear;

    public Book() {
    }

    public Book(int id, String title, String author, String publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(int id, int readerId, String title, String author, String publicationYear) {
        this.id = id;
        this.readerId = readerId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
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

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
