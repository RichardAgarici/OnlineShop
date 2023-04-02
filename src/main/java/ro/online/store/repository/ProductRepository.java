package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
