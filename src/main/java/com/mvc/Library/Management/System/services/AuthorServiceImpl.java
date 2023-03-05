package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Author;
import com.mvc.Library.Management.System.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author, Integer authorId) {
        Author selectedAuthor =authorRepository.findById(authorId).get();
        if(author.getName()!=null){
            selectedAuthor.setName(author.getName());
        }
        if(author.getDescription()!=null){
            selectedAuthor.setDescription(author.getDescription());
        }

        return authorRepository.save(selectedAuthor);
    }

    @Override
    public Void deleteAuthor(Integer authorId) {
         authorRepository.deleteById(authorId);
        return null;
    }

    @Override
    public Author getAuthorById(Integer authorId) {

        return authorRepository.findById(authorId).get();

    }
}
