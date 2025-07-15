package com.Smart_task.mini_project.DTO;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    @DBRef
    private List<String> roles;
}
