package com.alura.literAluraChallenge.entities;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private int downloads;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, String language, int downloads, Author author) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.downloads = downloads;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
// Getters, setters y toString()
}

