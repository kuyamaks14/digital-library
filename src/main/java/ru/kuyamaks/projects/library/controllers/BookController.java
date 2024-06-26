package ru.kuyamaks.projects.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kuyamaks.projects.library.dao.book.BookDAO;
import ru.kuyamaks.projects.library.dao.reader.ReaderDAO;
import ru.kuyamaks.projects.library.models.Book;
import ru.kuyamaks.projects.library.models.Reader;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookDAO bookDAO;
    private ReaderDAO readerDAO;

    @Autowired
    public BookController(BookDAO bookDAO, ReaderDAO readerDAO) {
        this.bookDAO = bookDAO;
        this.readerDAO = readerDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int bookId) {
        model.addAttribute("book", bookDAO.show(bookId));
        model.addAttribute("reader", readerDAO.show(bookDAO.getReaderIdByBookId(bookId)));
        model.addAttribute("new_reader", new Reader());
        model.addAttribute("readers", readerDAO.index());
        return "books/show";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBookForm(Model model, @PathVariable("id") int bookId) {
        model.addAttribute("book", bookDAO.show(bookId));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@PathVariable("id") int bookId, @ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        bookDAO.update(bookId, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int bookId) {
        bookDAO.delete(bookId);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/assign")
    public String assignBook(@PathVariable("id") int bookId, @ModelAttribute("reader") Reader reader) {
        bookDAO.assignBook(reader.getId(), bookId);
        return "redirect:/books/" + bookId;
    }

    @PatchMapping("/{id}/free")
    public String freeBook(@PathVariable("id") int bookId) {
        bookDAO.freeBook(bookId);
        return "redirect:/books/" + bookId;
    }
}
