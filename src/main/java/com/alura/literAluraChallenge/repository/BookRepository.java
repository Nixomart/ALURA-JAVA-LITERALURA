package com.alura.literAluraChallenge.repository;

import com.alura.literAluraChallenge.entities.Author;
import com.alura.literAluraChallenge.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);

    List<Book> findByLanguage(String language);

    long countByLanguage(String language);

    @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND (a.deathYear >= :year OR a.deathYear IS NULL)")
    List<Author> findAuthorsAliveInYear(int year);

}