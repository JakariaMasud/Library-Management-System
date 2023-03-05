package com.mvc.Library.Management.System.repositories;

import com.mvc.Library.Management.System.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
