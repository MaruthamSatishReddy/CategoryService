package com.easytobuy.service;

import com.easytobuy.model.CategoryRequest;
import com.easytobuy.model.CategoryResponse;

import java.util.List;

public interface CategoryService {
  CategoryResponse saveCategory(CategoryRequest categoryRequest);
  CategoryResponse getCategorieById(String categoryId);
  List<CategoryResponse> getAllCategories();
}
