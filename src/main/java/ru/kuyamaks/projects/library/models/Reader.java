package ru.kuyamaks.projects.library.models;

import javax.validation.constraints.*;

public class Reader {
    private int id;
    
    @NotEmpty(message = "Full name should not be empty")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "Not valid full name (i.e.: Ivanov Ivan Ivanovich)")
    private String fullName;

    @Min(value = 1920, message = "Birth year should be greater than 1920")
    @Max(value = 2017, message = "Birth year should be less than 2017")
    private int birthYear;

    public Reader() {
    }

    public Reader(int id, String fullName, int birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
