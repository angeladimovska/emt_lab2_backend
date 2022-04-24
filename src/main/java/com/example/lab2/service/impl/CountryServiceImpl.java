package com.example.lab2.service.impl;

import com.example.lab2.model.Country;
import com.example.lab2.repository.CountryRepository;
import com.example.lab2.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}
