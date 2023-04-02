package ro.online.store.convertor;

import ro.online.store.dto.CategoryDTO;
import ro.online.store.dto.CategoryInfoDTO;
import ro.online.store.entity.CategoryEntity;

public class CategoryConvertor {

    public static CategoryEntity map(CategoryDTO categoryDTO){
        return new CategoryEntity(categoryDTO.getName());
    }

    public static CategoryDTO mapDTO(CategoryEntity categoryEntity){
        return new CategoryDTO(
                categoryEntity.getName());
    }

    public static CategoryInfoDTO map(CategoryEntity categoryEntity){
        return new CategoryInfoDTO(categoryEntity.getId(),
                categoryEntity.getName());
    }
}
