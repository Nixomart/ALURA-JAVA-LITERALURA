package com.alura.literAluraChallenge.repository;

import com.alura.literAluraChallenge.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(String language);
}