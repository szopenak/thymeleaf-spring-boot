package com.akrot.bookcrossing.controllers;

import com.akrot.bookcrossing.model.Book;
import com.akrot.bookcrossing.model.BookDto;
import com.akrot.bookcrossing.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping
public class BookController
{
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public ModelAndView welcome() {
        return new ModelAndView("books").addObject("books", bookRepository.getAllFree());
    }

    @GetMapping("/share")
    public String showForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "add";
    }

    @PostMapping("/share")
    public String checkPersonInfo(@ModelAttribute("book") @Valid BookDto book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add";
        }

        Book newBook = Book.builder()
                .author(book.getAuthor())
                .title(book.getTitle())
                .releaseYear(book.getReleaseYear())
                .latitude(book.getLatitude())
                .longitude(book.getLongitude())
                .available(true)
                .build();

        bookRepository.save(newBook);
        return "redirect:/books";
    }
}
