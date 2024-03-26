package ukim.finki.backend.service;

import ukim.finki.backend.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
}
