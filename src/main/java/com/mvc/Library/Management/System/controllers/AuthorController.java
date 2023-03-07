package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Author;
import com.mvc.Library.Management.System.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String getAllAuthors(Model model){
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";

    }

    @PostMapping("/updateAuthor/{authorId}")
    public String updateAuthor(@ModelAttribute Author author, @PathVariable("authorId") Integer authorId, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("author",author);
            return "update-author";
        }
        authorService.updateAuthor(author,authorId);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }
    @GetMapping("/updateAuthor/{authorId}")
    public String showFormUpdateAuthor(Model model, @PathVariable("authorId") Integer authorId){
        Author author = authorService.getAuthorById(authorId);
        model.addAttribute("author",author);
        System.out.println("show form update called");
      return "update-author" ;
    }

    @RequestMapping(value = "/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id,Model model){
        authorService.deleteAuthor(id);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }
}
