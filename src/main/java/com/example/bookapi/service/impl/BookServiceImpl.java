package com.example.bookapi.service.impl;

import com.example.bookapi.domain.dto.BookDTO;
import com.example.bookapi.domain.models.Book;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.service.BookService;
import com.example.bookapi.service.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        final List<Book> all = bookRepository.findAll();
        return bookMapper.toDTOList(all);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        final Optional<Book> byIsbn = bookRepository.findByIsbn(bookDTO.getIsbn());
        checkIfBookAlreadyExist(bookDTO, byIsbn);
        Book newBook = bookMapper.toEntity(bookDTO);
        newBook = bookRepository.save(newBook);
        return bookMapper.toDTO(newBook);
    }

    private static void checkIfBookAlreadyExist(BookDTO bookDTO, Optional<Book> byIsbn) {
        if (byIsbn.isPresent()) {
            throw new IllegalArgumentException("Book with isbn: " + bookDTO.getIsbn() + " already exists.");
        }
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        final Optional<Book> byIsbn = bookRepository.findByIsbnAndIdNot(bookDTO.getIsbn(), id);
        checkIfBookAlreadyExist(bookDTO, byIsbn);
        Book book = this.getOneBookEntity(id);
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setAvgRating(bookDTO.getAvgRating());
        book = bookRepository.save(book);
        return bookMapper.toDTO(book);
    }

    private Book getOneBookEntity(Long id) {
        final Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        throw new IllegalArgumentException("Book with id: " + id + " does not exist.");
    }

    @Override
    public BookDTO getOneBook(Long id) {
        final Book book = this.getOneBookEntity(id);
        return bookMapper.toDTO(book);
    }

    @Override
    public void deleteBook(Long id) {
        final Book book = this.getOneBookEntity(id);
        bookRepository.delete(book);
    }


}
