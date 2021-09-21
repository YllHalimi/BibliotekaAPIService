package com.example.bibliotekaapiservice.controllers;


import com.example.bibliotekaapiservice.DTO.CategoryDTO;
import com.example.bibliotekaapiservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/getAllCategories")
   public ResponseEntity<List<CategoryDTO>> getAllCategories() {
       return new ResponseEntity<List<CategoryDTO>>(new ArrayList<CategoryDTO>(categoryService.getAllCategories()),
               HttpStatus.OK);
   }


    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<CategoryDTO>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
