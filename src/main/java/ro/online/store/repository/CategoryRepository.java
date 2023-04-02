package ro.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ro.online.store.dto.CategoryDTO;
import ro.online.store.dto.CategoryInfoDTO;
import ro.online.store.entity.CategoryEntity;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    Optional<CategoryEntity> findByName(String name);
}
