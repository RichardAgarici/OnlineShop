package ro.online.store.repository;

import org.springframework.data.repository.CrudRepository;
import ro.online.store.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
