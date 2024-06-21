package ru.kuyamaks.projects.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kuyamaks.projects.library.dao.reader.ReaderDAO;
import ru.kuyamaks.projects.library.models.Reader;

import javax.validation.Valid;

@Component
@RequestMapping("/readers")
public class ReaderController {
    private ReaderDAO readerDAO;

    @Autowired
    public ReaderController(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("readers", readerDAO.index());
        return "readers/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int readerId) {
        model.addAttribute("reader", readerDAO.show(readerId));
        model.addAttribute("books", readerDAO.getBooks(readerId));
        return "readers/show";
    }

    @GetMapping("/new")
    public String newReaderForm(Model model) {
        model.addAttribute("reader", new Reader());
        return "readers/new";
    }

    @PostMapping
    public String createReader(@ModelAttribute("reader") @Valid Reader reader, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "readers/new";
        }

        readerDAO.save(reader);
        return "redirect:/readers";
    }

    @GetMapping("/{id}/edit")
    public String readerEditForm(Model model, @PathVariable("id") int readerId) {
        model.addAttribute("reader", readerDAO.show(readerId));
        return "readers/edit";
    }

    @PatchMapping("/{id}")
    public String updateReader(@PathVariable("id") int readerId, @ModelAttribute("reader") @Valid Reader reader, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "readers/edit";
        }

        readerDAO.update(readerId, reader);
        return "redirect:/readers";
    }

    @DeleteMapping("/{id}")
    public String deleteReader(@PathVariable("id") int readerId) {
        readerDAO.delete(readerId);
        return "redirect:/readers";
    }
}
