package com.easytobuy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document(collection = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  @Id
  private String categoryId;
  private String categoryName;
  private String categoryDescription;
}
