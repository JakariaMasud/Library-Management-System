package com.mvc.Library.Management.System.repositories;

import com.mvc.Library.Management.System.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
