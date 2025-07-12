package com.Smart_task.mini_project.Controller;

import com.Smart_task.mini_project.Entity.UserEntity;
import com.Smart_task.mini_project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class health_check {
    @GetMapping("/health-check")
    public String healthcheck(){
        return "OK";
    }

    @Autowired
    private UserRepository repository;

    @PostMapping("/create")
    public UserEntity create(@RequestBody UserEntity user){
        System.out.println("entity is save"+user.getName());
        return repository.save(user);
    }
    @GetMapping("/find")
    public ResponseEntity<UserEntity> getUserByEmail(@RequestParam String email) {
        return repository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
   public String delete(@PathVariable String id){
         repository.deleteById(id);
        return "Entity is deleted";
   }
   @PutMapping("/{id}")
    public UserEntity upate(@PathVariable String id, @RequestBody UserEntity update){
        update.setId(id);
        return repository.save(update);
   }


}
