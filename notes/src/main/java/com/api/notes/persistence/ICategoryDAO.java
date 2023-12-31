package com.api.notes.persistence;

import com.api.notes.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryDAO {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Long id);

    Optional<Category> findById(Long id);
}
