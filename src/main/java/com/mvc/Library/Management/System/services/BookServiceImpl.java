package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Book;
import com.mvc.Library.Management.System.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Integer bookId) {
        book.setId(bookId);
        return bookRepository.save(book);
    }

    @Override
    public Void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
        return null;
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> books() {
        return bookRepository.findAll();
    }
}
