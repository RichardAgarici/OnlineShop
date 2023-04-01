package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.ManufacturerEntity;

public interface ManufacturerRepository extends CrudRepository<ManufacturerEntity, String> {
}
