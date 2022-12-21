package com.example.bookapi.service;

import com.example.bookapi.domain.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    BookDTO getOneBook(Long id);

    void deleteBook(Long id);
}
