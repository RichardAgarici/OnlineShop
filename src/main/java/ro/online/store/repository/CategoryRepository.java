package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {
}
