package com.example.bookapi.service.mapper;

import com.example.bookapi.domain.dto.BookDTO;
import com.example.bookapi.domain.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper implements EntityMapper<Book, BookDTO> {
    @Override
    public Book toEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getId(), bookDTO.getAuthor(), bookDTO.getTitle(), bookDTO.getIsbn(), bookDTO.getAvgRating(), bookDTO.getPrice());
    }

    @Override
    public BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getAuthor(), book.getTitle(), book.getIsbn(), book.getAvgRating(), book.getPrice());
    }
}
