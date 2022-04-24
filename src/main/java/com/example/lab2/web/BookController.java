package com.example.lab2.web;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.enumerations.Category;
import com.example.lab2.service.AuthorService;
import com.example.lab2.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping({"/","/books"})
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);

        //List<Author> authors = this.authorService.findAll();
        //model.addAttribute("authors", authors);
        return "books";
    }

    @GetMapping("/books/add-form")
    public String addBookPage(Model model) {
        List<Author> authors = this.authorService.findAll();
        model.addAttribute("authors", authors);

        model.addAttribute("categories", Category.values());
        return "add-book";
    }

    @GetMapping("/books/edit-form/{id}")
    public String editBooksPage(@PathVariable Long id, Model model) {
        if (this.bookService.findById(id).isPresent()) {
            Book book = this.bookService.findById(id).get();
            model.addAttribute("book", book);
            List<Author> authors = this.authorService.findAll();
            model.addAttribute("authors", authors);
            model.addAttribute("categories", Category.values());
            return "add-book";
        }
        return "redirect:/books?error=ProductNotFound";
    }

    @PostMapping("/books/add")
    public String saveProduct(@RequestParam(required = false) Long id,
                              @RequestParam String name,
                              @RequestParam Category category,
                              @RequestParam Long author,
                              @RequestParam Integer availableCopies) {
        if (id != null) {
            this.bookService.edit(id, name, category, author, availableCopies);
        } else {
            this.bookService.save(name, category, author, availableCopies);
        }
        return "redirect:/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
}
