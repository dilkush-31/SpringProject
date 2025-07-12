package com.Smart_task.mini_project.Repository;

import com.Smart_task.mini_project.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
//    List<Entity> findByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
