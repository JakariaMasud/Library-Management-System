package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Category;
import com.mvc.Library.Management.System.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Integer categoryId) {
        category.setId(categoryId);
        return categoryRepository.save(category);
    }

    @Override
    public Void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
        return null;
    }

    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
