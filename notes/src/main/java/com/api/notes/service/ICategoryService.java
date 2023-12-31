package com.api.notes.service;

import com.api.notes.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category category);
    void deleteById(Long id);
}
