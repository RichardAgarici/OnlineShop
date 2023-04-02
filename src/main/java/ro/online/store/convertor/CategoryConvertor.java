package ro.online.store.convertor;

import ro.online.store.dto.CategoryDTO;
import ro.online.store.entity.CategoryEntity;

public class CategoryConvertor {

    public static CategoryEntity map(CategoryDTO categoryDTO){
        return new CategoryEntity(categoryDTO.getName());
    }

    public static CategoryDTO map(CategoryEntity categoryEntity){
        return new CategoryDTO(
                categoryEntity.getName());
    }
}
