package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author create(String name, String surname, Long countryId);
}
