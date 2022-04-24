package com.example.lab2.service;

import com.example.lab2.model.Country;

import java.util.List;

public interface CountryService {
    Country create(String name, String continent);

    List<Country> findAll();
}
