package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Author;
import com.mvc.Library.Management.System.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/addAuthor")
    public String showAuthorForm(Model model){
        model.addAttribute("author",new Author());
        return "add-author";
    }

    @PostMapping("/authors")
    public String saveAuthor(@ModelAttribute Author author,Model model){
        if(author!=null){
            authorService.addAuthor(author);
        }
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";

    }
    @GetMapping("/authors")
    public String getAllAuthors(@ModelAttribute Author author,Model model){
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";

    }
}
