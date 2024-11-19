package com.alura.literAluraChallenge.service;

import com.alura.literAluraChallenge.entities.Author;
import com.alura.literAluraChallenge.entities.Book;
import com.alura.literAluraChallenge.repository.AuthorRepository;
import com.alura.literAluraChallenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public void saveBooks(List<Book> books) {
        for (Book book : books) {
            if (!bookRepository.existsByTitle(book.getTitle())) {
                bookRepository.save(book);
            }
        }
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAuthorsAliveInYear(year);
    }
    public long countBooksByLanguage(String language) {
        return bookRepository.countByLanguage(language);
    }
}