package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
