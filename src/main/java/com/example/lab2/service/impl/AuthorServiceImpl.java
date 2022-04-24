package com.example.lab2.service.impl;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;
import com.example.lab2.model.exceptions.AuthorNotFoundException;
import com.example.lab2.model.exceptions.CountryNotFoundException;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.repository.CountryRepository;
import com.example.lab2.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Long countryId) {

        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));

        return this.authorRepository.save(new Author(name,surname,country));
    }
}
