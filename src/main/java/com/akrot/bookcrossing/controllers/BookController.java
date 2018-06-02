package com.akrot.bookcrossing.controllers;

import com.akrot.bookcrossing.model.Book;
import com.akrot.bookcrossing.model.BookDto;
import com.akrot.bookcrossing.repository.BookRepository;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping
public class BookController
{
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public ModelAndView welcome(
            @RequestParam(required = false) String take,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        if (take != null && take.matches("[0-9]*")){
            Long id = Long.valueOf(take);
            Optional<Book> toGet = bookRepository.findById(id);
            if (toGet.isPresent()) {
                Book book = toGet.get();
                book.setAvailable(false);
                bookRepository.save(book);
            }
        }
        if (title != null) {
            return new ModelAndView("books").addObject("books", bookRepository.getByTitleAndAvailable(title, true));
        }
        if (author != null) {
            return new ModelAndView("books").addObject("books", bookRepository.getByAuthorAndAvailable(author, true));
        }
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
