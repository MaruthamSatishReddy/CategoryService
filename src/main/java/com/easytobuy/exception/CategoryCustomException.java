package com.easytobuy.exception;

import lombok.Data;

@Data
public class CategoryCustomException extends RuntimeException {
  private String errorCode;

  public CategoryCustomException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
