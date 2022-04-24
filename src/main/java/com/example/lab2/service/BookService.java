package com.example.lab2.service;

import com.example.lab2.model.Book;
import com.example.lab2.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long author, Integer availableCopies);

    void deleteById(Long id);

    void markAsTaken(Long id);


}
