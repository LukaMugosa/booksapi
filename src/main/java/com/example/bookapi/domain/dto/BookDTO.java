package com.example.bookapi.domain.dto;

import java.util.Objects;

public class BookDTO {
    private Long id;
    private String author;
    private String title;
    private String isbn;
    private Double avgRating;
    private Integer price;

    public BookDTO(Long id, String author, String title, String isbn, Double avgRating, Integer price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.avgRating = avgRating;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(author, bookDTO.author) && Objects.equals(title, bookDTO.title) && Objects.equals(isbn, bookDTO.isbn) && Objects.equals(avgRating, bookDTO.avgRating) && Objects.equals(price, bookDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, isbn, avgRating, price);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", avgRating=" + avgRating +
                ", price=" + price +
                '}';
    }
}
