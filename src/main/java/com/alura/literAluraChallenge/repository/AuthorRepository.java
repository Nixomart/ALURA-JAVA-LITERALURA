package com.alura.literAluraChallenge.repository;


import com.alura.literAluraChallenge.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
