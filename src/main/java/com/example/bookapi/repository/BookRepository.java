package com.example.bookapi.repository;

import com.example.bookapi.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByIsbnAndIdNot(String isbn, Long id);
}
