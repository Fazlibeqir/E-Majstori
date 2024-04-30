package ukim.finki.backend.service;

import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    Category create(CategoryDTO categoryDTO);
    void deleteById(Long id);
}
