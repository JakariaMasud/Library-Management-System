package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Author;

import java.util.List;

public interface AuthorService {
     Author addAuthor(Author author);
     List<Author> getAllAuthors();
     Author updateAuthor(Author author,Integer authorId);
     Void deleteAuthor(Integer authorId);
     Author getAuthorById(Integer authorId);
}
