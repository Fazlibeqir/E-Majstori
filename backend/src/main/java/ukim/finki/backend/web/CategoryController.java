package ukim.finki.backend.web;
import java.util.stream.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Location;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
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
    public ResponseEntity<Category> getLocationById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return ResponseEntity.ok().body(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestParam String name){
        if(name == null){
            return ResponseEntity.badRequest().build();
        }
         this.categoryService.create(name);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.categoryService.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
