package edu.spring.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название книги должно быть от 2 до 100 символов длинной ")
    private String title;

    @NotEmpty(message = "Автор не должен быть пустым")
    @Size(min = 2, max = 100, message = "Имя автора должно быть от 2 до 100 символов длинной ")
    private String author;

    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    private int year;

    public Book() {

    }

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Название книги не должно быть пустым") @Size(min = 2, max = 100, message = "Название книги должно быть от 2 до 100 символов длинной ") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "Название книги не должно быть пустым") @Size(min = 2, max = 100, message = "Название книги должно быть от 2 до 100 символов длинной ") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "Автор не должен быть пустым") @Size(min = 2, max = 100, message = "Имя автора должно быть от 2 до 100 символов длинной ") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotEmpty(message = "Автор не должен быть пустым") @Size(min = 2, max = 100, message = "Имя автора должно быть от 2 до 100 символов длинной ") String author) {
        this.author = author;
    }

    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    public int getYear() {
        return year;
    }

    public void setYear(@Min(value = 1500, message = "Год должен быть больше, чем 1500") int year) {
        this.year = year;
    }
}
