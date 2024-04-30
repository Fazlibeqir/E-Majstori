package ukim.finki.backend.web;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.dto.CategoryDTO;
import ukim.finki.backend.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return ResponseEntity.ok().body(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO){
        if(categoryDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if(categoryDTO.getName() == null){
            return ResponseEntity.badRequest().build();
        }
         this.categoryService.create(categoryDTO);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        this.categoryService.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
