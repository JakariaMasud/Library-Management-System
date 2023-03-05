package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    Category updateCategory(Category category,Integer categoryId);
    Void deleteCategory(Integer categoryId);
    List<Category> categories();
    Category getCategoryById(Integer categoryId);
}
