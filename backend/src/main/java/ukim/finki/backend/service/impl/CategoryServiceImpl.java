package ukim.finki.backend.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.dto.CategoryDTO;
import ukim.finki.backend.repository.CategoryRepository;
import ukim.finki.backend.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(CategoryDTO categoryDTO) {
        return categoryRepository.save(new Category(categoryDTO.getName()));
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            categoryRepository.deleteById(id);
    }
}