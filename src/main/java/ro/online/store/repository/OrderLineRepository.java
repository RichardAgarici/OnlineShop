package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.OrderLineEntity;

public interface OrderLineRepository extends CrudRepository<OrderLineEntity, Integer> {
}
