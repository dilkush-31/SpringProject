package com.Smart_task.mini_project.Controller;


import com.Smart_task.mini_project.DTO.LoginRequest;
import com.Smart_task.mini_project.DTO.RegisterRequest;
import com.Smart_task.mini_project.Entity.Entity_Task;
import com.Smart_task.mini_project.Repository.Repo_task;
import com.Smart_task.mini_project.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthContro {

    private final UserService userService;

    @Autowired
    private Repo_task repoTask;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        userService.registerUser(registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
repoTask.deleteById(id);
return "task is deleted";
    }

    @GetMapping("/find")
    public List<Entity_Task>getlist(){
return repoTask.findAll();
    }

    @PutMapping("/{id}")
    public Entity_Task update(@PathVariable String id,@RequestBody Entity_Task update){
        update.setId(id);
        return repoTask.save(update);
    }

}
