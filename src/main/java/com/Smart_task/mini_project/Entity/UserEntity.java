package com.Smart_task.mini_project.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Smart-database")
public class UserEntity {
    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

    private List <String> roles=new ArrayList<>();

}
