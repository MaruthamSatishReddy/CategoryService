package com.easytobuy.api;

import com.easytobuy.model.CategoryRequest;
import com.easytobuy.model.CategoryResponse;
import com.easytobuy.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
  @Autowired CategoryService categoryService;

  @PostMapping
  public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest categoryRequest) {
    categoryRequest.setCategoryId(UUID.randomUUID().toString().split("-")[0]);
    return new ResponseEntity<>(categoryService.saveCategory(categoryRequest), HttpStatus.CREATED);
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<CategoryResponse> getCategorieById(@PathVariable("categoryId") String categoryId) {
    return new ResponseEntity<>(categoryService.getCategorieById(categoryId), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<CategoryResponse>> getCategories() {
    return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
  }
}
