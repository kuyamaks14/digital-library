package ru.kuyamaks.projects.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    private int readerId;

    @NotEmpty(message = "Book title should not be empty")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @Min(value = 1500, message = "Publication year should be greater than 1700")
    @Max(value = 2020, message = "Publication year should be less than 2024")
    private int publicationYear;

    public Book() {
    }

    public Book(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(int id, int readerId, String title, String author, int publicationYear) {
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
