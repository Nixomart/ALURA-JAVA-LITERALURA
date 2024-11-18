package com.alura.literAluraChallenge.service;

import com.alura.literAluraChallenge.entities.Book;
import com.alura.literAluraChallenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void saveBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}