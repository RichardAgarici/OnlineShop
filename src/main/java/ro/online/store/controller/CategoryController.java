package ro.online.store.controller;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.online.store.dto.CategoryDTO;
import ro.online.store.dto.CategoryInfoDTO;
import ro.online.store.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@ControllerAdvice
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryInfoDTO> create(@RequestBody @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.saveCategory(categoryDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryInfoDTO> findCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @GetMapping("/")
    public ResponseEntity<CategoryInfoDTO> findByName(@RequestParam(name = "categoryName") String name){
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<CategoryInfoDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(categoryService.deleteCategory(id)){
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.notFound().build();
    }


}
