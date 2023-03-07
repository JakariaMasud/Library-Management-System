package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book,Integer bookId);
    Void deleteBook(Integer bookId);
    Book getBookById(Integer id);
    List<Book> books();
}
