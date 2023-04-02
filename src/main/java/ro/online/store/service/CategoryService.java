package ro.online.store.service;

import org.springframework.dao.EmptyResultDataAccessException;
import ro.online.store.convertor.CategoryConvertor;
import ro.online.store.dto.CategoryDTO;
import ro.online.store.dto.CategoryInfoDTO;
import ro.online.store.entity.CategoryEntity;
import ro.online.store.exception.CategoryCustomException;
import ro.online.store.repository.CategoryRepository;
import ro.online.store.utils.CustomFakerUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CustomFakerUser customFakerCategories;

    public CategoryService(
            CategoryRepository categoryRepository,
            CustomFakerUser customFakerCategories) {
        this.categoryRepository = Objects.requireNonNull(categoryRepository);
        this.customFakerCategories = Objects.requireNonNull(customFakerCategories);
    }

    public CategoryInfoDTO saveCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = CategoryConvertor.map(categoryDTO);
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return CategoryConvertor.map(savedCategoryEntity);
    }

    public CategoryInfoDTO getCategoryById(Integer id){
        CategoryEntity searchedCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryCustomException("Could not find category with id: " + id));
        return CategoryConvertor.map(searchedCategory);
    }

    public CategoryInfoDTO findByName(String name){
        CategoryEntity foundCategory = categoryRepository.findByName(name)
                .orElseThrow(() -> new CategoryCustomException("Could not found category"));
        return CategoryConvertor.map(foundCategory);
    }

    public List<CategoryInfoDTO> findAllCategories(){
        List<CategoryEntity> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryEntity -> categories.add(categoryEntity));
       List<CategoryInfoDTO> categoryInfoDTOS = categories.stream()
               .map(categoryEntity -> CategoryConvertor.map(categoryEntity))
               .toList();
       if(categoryInfoDTOS.isEmpty()){
           throw new CategoryCustomException("No categories found in the database");
       }
       return categoryInfoDTOS;
    }

    public Boolean deleteCategory(Integer id){
        try {
            categoryRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (EmptyResultDataAccessException e){
            return Boolean.FALSE;
        }
    }
}
