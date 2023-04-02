package ro.online.store.service;

import org.springframework.stereotype.Service;
import ro.online.store.convertor.CategoryConvertor;
import ro.online.store.dto.CategoryDTO;
import ro.online.store.entity.CategoryEntity;
import ro.online.store.repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = CategoryConvertor.map(categoryDTO);
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return CategoryConvertor.map(savedCategoryEntity);
    }



}
