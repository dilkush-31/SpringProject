package com.Smart_task.mini_project.Service;

import com.Smart_task.mini_project.Entity.Entity_Task;
import com.Smart_task.mini_project.Entity.UserEntity;
import com.Smart_task.mini_project.Repository.Repo_task;
import com.Smart_task.mini_project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private Repo_task taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Entity_Task> getTasks() {

        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<UserEntity> entity = userRepository.findByEmail(details.getUsername());

        if(entity.isEmpty()) return new ArrayList<>();

        UserEntity user = entity.get();

        return taskRepository.findAllByUserId(user.getId());
    }
}
