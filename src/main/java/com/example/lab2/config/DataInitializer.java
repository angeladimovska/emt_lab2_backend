package com.example.lab2.config;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;
import com.example.lab2.model.enumerations.Category;
import com.example.lab2.service.AuthorService;
import com.example.lab2.service.BookService;
import com.example.lab2.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
@AllArgsConstructor
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    @PostConstruct
    public void initData() {
        for (int i = 1; i < 5; i++) {
            this.countryService.create("Country"+i ,"Continent"+i);
        }
        List<Country> countries = this.countryService.findAll();

        this.authorService.create("Name1" ,"Surname1", countries.get(0).getId());
        this.authorService.create("Name2" ,"Surname2", countries.get(1).getId());
        this.authorService.create("Name3" ,"Surname3", countries.get(2).getId());

        List<Author> authors=this.authorService.findAll();

        this.bookService.save("BookName1", Category.BIOGRAPHY, authors.get(0).getId(), 1);
        this.bookService.save("BookName2", Category.CLASSICS, authors.get(1).getId(), 10);
        this.bookService.save("BookName3", Category.DRAMA, authors.get(1).getId(), 12);
        this.bookService.save("BookName4", Category.THRILLER, authors.get(0).getId(), 6);
        this.bookService.save("BookName5", Category.FANTASY, authors.get(2).getId(), 20);
    }
}
