package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Author;
import com.mvc.Library.Management.System.entities.Category;
import com.mvc.Library.Management.System.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(value = "/addCategory")
    public String showCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "add-category";
    }

    @PostMapping(value ="/categories" )
    public String saveCategory(@ModelAttribute Category category,Model model){
        categoryService.addCategory(category);
        model.addAttribute("categories",categoryService.categories());
        return "categories";
    }

    @GetMapping (value ="/categories" )
    public String getCategories(@ModelAttribute Category category, Model model){
        model.addAttribute("categories",categoryService.categories());
        return "categories";
    }
}
