package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.repository.CategoryRepository;
import ukim.finki.backend.repository.JobProviderRepository;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobProviderService;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}