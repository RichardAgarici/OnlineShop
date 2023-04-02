package ro.online.store.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.online.store.dto.CategoryDTO;
import ro.online.store.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@ControllerAdvice
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.saveCategory(categoryDTO));
    }
}
