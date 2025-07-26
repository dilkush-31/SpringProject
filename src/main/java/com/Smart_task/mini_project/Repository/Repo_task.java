package com.Smart_task.mini_project.Repository;

import com.Smart_task.mini_project.Entity.Entity_Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Repo_task extends MongoRepository<Entity_Task,String> {

    List<Entity_Task> findAllByUserId(String id);
}
