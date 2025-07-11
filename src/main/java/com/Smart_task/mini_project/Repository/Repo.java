package com.Smart_task.mini_project.Repository;

import com.Smart_task.mini_project.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface Repo extends MongoRepository<UserEntity,String> {
//    List<Entity> findByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
