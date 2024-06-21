package ru.kuyamaks.projects.library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Reader {
    private int id;
    
    @NotEmpty(message = "Full name should not be empty")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "Not valid full name (i.e.: Ivanov Ivan Ivanovich)")
    private String fullName;
    
    @NotEmpty(message = "Birth year should not be empty")
    @Size(min = 1920, max = 2017, message = "Birth year should be between 1920 and 2017")
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
