package com.example.bookapi.controllers;

import com.example.bookapi.domain.dto.BookDTO;
import com.example.bookapi.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookDTO getOneBook(@PathVariable("id") Long id) {
        return bookService.getOneBook(id);
    }

    @PutMapping("/books/{id}")
    public BookDTO updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        bookDTO = bookService.updateBook(id, bookDTO);
        return bookDTO;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/books")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        bookDTO = bookService.createBook(bookDTO);
        return bookDTO;
    }

}
