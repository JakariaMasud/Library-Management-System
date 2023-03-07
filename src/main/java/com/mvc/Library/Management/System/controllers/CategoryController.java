package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Category;
import com.mvc.Library.Management.System.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/updateCategory/{id}",method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute Category category, @PathVariable("id") Integer id,Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("category",category);
            return "update-category";
        }
        categoryService.updateCategory(category,id);
        model.addAttribute("categories",categoryService.categories());
        return "categories";

    }
    @RequestMapping(value = "/updateCategory/{id}",method = RequestMethod.GET)
    public String showUpdateCategoryForm( @PathVariable("id") Integer id,Model model){
        Category selectedCategory = categoryService.getCategoryById(id);
        model.addAttribute("category",selectedCategory);
        return "update-category";

    }
    @RequestMapping(value = "/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Integer categoryId,Model model){
        categoryService.deleteCategory(categoryId);
        model.addAttribute("categories",categoryService.categories());
        return "categories";
    }
}
