package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Book;
import com.mvc.Library.Management.System.services.AuthorService;
import com.mvc.Library.Management.System.services.BookService;
import com.mvc.Library.Management.System.services.CategoryService;
import com.mvc.Library.Management.System.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    AuthorService authorService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/addBook")
    public String showBookForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("categories",categoryService.categories());
        model.addAttribute("publishers",publisherService.publishers());

        return "add-book";
    }

    @GetMapping("/books")
    public String books(Model model){
        model.addAttribute("books",bookService.books());
        return "books";
    }

    @PostMapping("/books")
    public String saveBook(Model model, @ModelAttribute Book book, BindingResult result){
        if(!result.hasErrors()){
            bookService.addBook(book);
        }
        model.addAttribute("books",bookService.books());
        return "books";
    }
    @RequestMapping(value = "/updateBook/{bookId}")
    public String showUpdateForm(@PathVariable("bookId") Integer bookId,Model model){
        Book selectedBook = bookService.getBookById(bookId);
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("categories",categoryService.categories());
        model.addAttribute("publishers",publisherService.publishers());
        model.addAttribute("book",selectedBook);
        return "update-book";
    }
    @PostMapping("/updateBook/{bookId}")
    public String updateBook(@PathVariable("bookId") Integer bookId,@ModelAttribute Book book,BindingResult result,Model model ){
        if(result.hasErrors()){
            model.addAttribute("book",book);
            return "update-book";
        }

        bookService.updateBook(book,bookId);
        model.addAttribute("books",bookService.books());
        return "books";
    }
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId,Model model){
        bookService.deleteBook(bookId);
        model.addAttribute("books",bookService.books());
        return "books";
    }


}
