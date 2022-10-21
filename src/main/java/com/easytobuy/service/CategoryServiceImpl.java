package com.easytobuy.service;

import com.easytobuy.entity.Category;
import com.easytobuy.exception.CategoryCustomException;
import com.easytobuy.model.CategoryRequest;
import com.easytobuy.model.CategoryResponse;
import com.easytobuy.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
  @Autowired CategoryRepository categoryRepository;

  @Override
  public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
    Category category =
        Category.builder()
            .categoryDescription(categoryRequest.getCategoryDescription())
            .categoryName(categoryRequest.getCategoryName())
            .build();
    categoryRepository.save(category);
    log.info("CategoryServiceImpl:saveCategory::categoryId" + category.getCategoryId());
    return CategoryResponse.builder()
            .categoryName(categoryRequest.getCategoryName())
            .categoryId(categoryRequest.getCategoryId())
            .categoryDescription(categoryRequest.getCategoryDescription())
            .build();
  }

  @Override
  public CategoryResponse getCategorieById(String categoryId) {
    log.info("CategoryServiceImpl:getCategorieById::categoryId" + categoryId);
    Optional<Category> category =
        Optional.ofNullable(
            categoryRepository
                .findById(categoryId)
                .orElseThrow(
                    () ->
                        new CategoryCustomException(
                            "No Category found with given CategoryId", "CATEGORY_NOT_FOUND")));
    CategoryResponse categoryResponse =
        CategoryResponse.builder()
            .categoryId(category.get().getCategoryId())
            .categoryName(category.get().getCategoryName())
            .categoryDescription(category.get().getCategoryDescription())
            .build();
    return categoryResponse;
  }

  @Override
  public List<CategoryResponse> getAllCategories() {
    List<Category> getAllCategories =categoryRepository.findAll();
    return getAllCategories.stream().map(category->
      CategoryResponse.builder()
              .categoryId(category.getCategoryId())
              .categoryName(category.getCategoryName())
              .categoryDescription(category.getCategoryDescription())
              .build()).collect(Collectors.toList());
    }
  }